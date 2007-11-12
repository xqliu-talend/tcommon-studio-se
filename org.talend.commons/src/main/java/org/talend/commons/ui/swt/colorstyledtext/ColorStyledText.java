// ============================================================================
//
// Copyright (C) 2006-2007 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the  agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//   
// ============================================================================
package org.talend.commons.ui.swt.colorstyledtext;

import java.util.ArrayList;

import org.eclipse.jface.text.rules.IToken;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ExtendedModifyEvent;
import org.eclipse.swt.custom.ExtendedModifyListener;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.talend.commons.exception.ExceptionHandler;
import org.talend.commons.i18n.internal.Messages;
import org.talend.commons.ui.swt.colorstyledtext.jedit.Mode;
import org.talend.commons.ui.swt.colorstyledtext.jedit.Modes;
import org.talend.commons.ui.swt.colorstyledtext.rules.CToken;
import org.talend.commons.ui.swt.colorstyledtext.scanner.ColoringScanner;

/**
 * This component is an adaptation of a Color Editor for a StyledText.
 * 
 * The original editor can be found on http://www.gstaff.org/colorEditor/ <br/>
 * 
 * <b>How to use it, example :</b> <br/> <i> ColorManager colorManager = new
 * ColorManager(CoreActivator.getDefault().getPreferenceStore());<br/> ColorStyledText text = new
 * ColorStyledText(parent, SWT.H_SCROLL | SWT.V_SCROLL, colorManager, ECodeLanguage.PERL.getName());</i> <br/><br/>
 * 
 * $Id$
 * 
 */
public class ColorStyledText extends StyledText {

    private final ColorManager colorManager;

    private final ColoringScanner scanner;

    private final String languageMode;

    private final MenuItem pasteItem;

    private boolean coloring = true;

    public ColorStyledText(Composite parent, int style, ColorManager colorManager, String languageMode) {
        super(parent, style);
        this.languageMode = languageMode;
        this.colorManager = colorManager;

        ISharedImages sharedImages = PlatformUI.getWorkbench().getSharedImages();
        Image image = sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_COPY).createImage();
        Menu popupMenu = new Menu(this);
        MenuItem copyItem = new MenuItem(popupMenu, SWT.PUSH);
        copyItem.setText(Messages.getString("ColorStyledText.CopyItem.Text")); //$NON-NLS-1$
        copyItem.setImage(image);
        copyItem.addListener(SWT.Selection, new Listener() {

            public void handleEvent(Event event) {
                copy();
            }
        });

        image = sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_PASTE).createImage();
        pasteItem = new MenuItem(popupMenu, SWT.PUSH);
        pasteItem.setText(Messages.getString("ColorStyledText.PasteItem.Text")); //$NON-NLS-1$
        pasteItem.setData(this);
        pasteItem.setImage(image);
        pasteItem.addListener(SWT.Selection, new Listener() {

            public void handleEvent(Event event) {
                paste();
            }
        });

        this.setMenu(popupMenu);
        MenuItem selectAllItem = new MenuItem(popupMenu, SWT.PUSH);
        selectAllItem.setText(Messages.getString("ColorStyledText.SelectAllItem.Text")); //$NON-NLS-1$
        selectAllItem.addListener(SWT.Selection, new Listener() {

            public void handleEvent(Event event) {
                selectAll();
            }
        });
        this.setMenu(popupMenu);

        Listener selectAllListener = new Listener() {

            public void handleEvent(Event event) {
                if (event.character == '\u0001') { // CTRL + A
                    selectAll();
                }
            }
        };

        addListener(SWT.KeyDown, selectAllListener);

        Mode mode = Modes.getMode(languageMode + ".xml");
        scanner = new ColoringScanner(mode, colorManager);

        addExtendedModifyListener(modifyListener);
    }

    @Override
    public void setText(String text) {
        super.setText(text);

        colorize(scanner);
    }

    protected void colorize(ColoringScanner scanner) {
        ArrayList<StyleRange> styles = new ArrayList<StyleRange>();
        if (this.coloring) {
            scanner.parse(this.getText());
            IToken token;

            do {
                token = scanner.nextToken();
                if (!token.isEOF()) {
                    if (token instanceof CToken) {
                        CToken ctoken = (CToken) token;
                        StyleRange styleRange;
                        styleRange = new StyleRange();
                        styleRange.start = scanner.getTokenOffset();
                        styleRange.length = scanner.getTokenLength();
                        if (ctoken.getType() == null) {
                            styleRange.fontStyle = colorManager.getStyleFor(ctoken.getColor());
                            styleRange.foreground = colorManager.getColor(ctoken.getColor());
                        } else {
                            styleRange.fontStyle = colorManager.getStyleForType(ctoken.getColor());
                            styleRange.foreground = colorManager.getColorForType(ctoken.getColor());
                        }
                        styles.add(styleRange);
                    }
                }
            } while (!token.isEOF());

        } else {
            StyleRange styleRange = new StyleRange();
            styles.add(styleRange);
            styleRange.start = 0;
            styleRange.length = this.getText().getBytes().length;
            styleRange.foreground = null;
        }
        setStyles(styles);
    }

    public void setStyles(final ArrayList<StyleRange> styles) {
        getDisplay().asyncExec(new Runnable() {

            public void run() {
                if (ColorStyledText.this.isDisposed()) {
                    return;
                }
                try {
                    int countChars = getCharCount();
                    for (int i = 0; i < styles.size(); i++) {
                        StyleRange styleRange = styles.get(i);
                        // System.out.println("styleRange.start="+styleRange.start);
                        // System.out.println("styleRange.length="+styleRange.length);
                        if (!(0 <= styleRange.start && styleRange.start + styleRange.length <= countChars)) {
                            continue;
                        }
                        setStyleRange(styleRange);
                    }
                } catch (RuntimeException t) {
                    // System.out.println(t);
                    ExceptionHandler.process(t);
                }
            }
        });
    }

    ExtendedModifyListener modifyListener = new ExtendedModifyListener() {

        public void modifyText(ExtendedModifyEvent event) {
            colorize(scanner);
        }
    };

    public ColorManager getColorManager() {
        return this.colorManager;
    }

    public String getLanguageMode() {
        return this.languageMode;
    }

    public ColoringScanner getScanner() {
        return this.scanner;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.swt.custom.StyledText#setEditable(boolean)
     */
    @Override
    public void setEditable(boolean editable) {
        super.setEditable(editable);
        pasteItem.setEnabled(editable);
    }

    /**
     * Getter for coloring.
     * 
     * @return the coloring
     */
    public boolean isColoring() {
        return this.coloring;
    }

    /**
     * Sets the coloring.
     * 
     * @param coloring the coloring to set
     */
    public void setColoring(boolean coloring) {
        boolean wasDifferent = this.coloring != coloring;
        this.coloring = coloring;
        if (wasDifferent) {
            colorize(getScanner());
        }
    }

}
