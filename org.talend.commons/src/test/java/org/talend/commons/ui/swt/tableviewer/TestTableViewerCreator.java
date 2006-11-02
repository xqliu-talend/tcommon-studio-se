// ============================================================================
//
// Talend Community Edition
//
// Copyright (C) 2006 Talend - www.talend.com
//
// This library is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 2.1 of the License, or (at your option) any later version.
//
// This library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
//
// You should have received a copy of the GNU General Public License
// along with this program; if not, write to the Free Software
// Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
//
// ============================================================================
package org.talend.commons.ui.swt.tableviewer;

import java.util.ArrayList;
import java.util.Random;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ComboBoxCellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.talend.commons.ui.swt.tableviewer.TableViewerCreator.LAYOUT_MODE;
import org.talend.commons.ui.swt.tableviewer.TableViewerCreator.LINE_SELECTION;
import org.talend.commons.ui.swt.tableviewer.TableViewerCreator.SHOW_SELECTION;
import org.talend.commons.ui.swt.tableviewer.behavior.CellEditorValueAdapter;
import org.talend.commons.ui.swt.tableviewer.behavior.IColumnImageProvider;
import org.talend.commons.ui.swt.tableviewer.tableeditor.CheckboxTableEditorContent;
import org.talend.commons.ui.swt.tableviewer.tableeditor.TableEditorContent;
import org.talend.commons.utils.DataObject;
import org.talend.commons.utils.data.bean.IBeanPropertyAccessors;

/**
 * 
 * Test class of <code>TableViewerCreator</code>. <br/>
 * 
 * $Id$
 * 
 */
public final class TestTableViewerCreator {
    /**
     * Default Constructor.
     * Must not be used.
     */
    private TestTableViewerCreator() {
    }

    private static ArrayList<DataObject> list;

    public static void main(String[] args) {
        Display display = new Display();
        final Shell shell1 = new Shell(display);
        shell1.setLayout(new GridLayout());
        
        ImageDescriptor imageDescriptor = ImageDescriptor.createFromFile(TestTableViewerCreator.class, "error_tsk.gif");
        final Image image = imageDescriptor.createImage();

        final TableViewerCreator tableViewerCreator = new TableViewerCreator(shell1);
        tableViewerCreator.setHeaderVisible(true);
        tableViewerCreator.setBorderVisible(true);
        tableViewerCreator.setLinesVisible(true);
        tableViewerCreator.setShowSelection(SHOW_SELECTION.FULL);   
        tableViewerCreator.setLineSelection(LINE_SELECTION.MULTI);
        tableViewerCreator.setLayoutMode(LAYOUT_MODE.FILL_HORIZONTAL);
        tableViewerCreator.setUseCustomColoring(true);
        tableViewerCreator.setAdjustWidthValue(-50);
//        tableViewerCreator.setFirstVisibleColumnIsSelection(true);
//        tableViewerCreator.setLabelProvider(new ITableLabelProvider() {
//
//            public Image getColumnImage(Object element, int columnIndex) {
//                return image;
//            }
//
//            public String getColumnText(Object element, int columnIndex) {
//                // TODO Auto-generated method stub
//                return null;
//            }
//
//            public void addListener(ILabelProviderListener listener) {
//                // TODO Auto-generated method stub
//                
//            }
//
//            public void dispose() {
//                // TODO Auto-generated method stub
//                
//            }
//
//            public boolean isLabelProperty(Object element, String property) {
//                // TODO Auto-generated method stub
//                return false;
//            }
//
//            public void removeListener(ILabelProviderListener listener) {
//                // TODO Auto-generated method stub
//                
//            }
//            
//        });

        // tableEditor.setCheckboxInFirstColumn(true);

        final Table table = tableViewerCreator.createTable();
        GridData gridData = new GridData(GridData.FILL_HORIZONTAL, GridData.GRAB_HORIZONTAL);
        gridData.grabExcessHorizontalSpace = true;
//        gridData.horizontalAlignment = GridData.FILL_HORIZONTAL;
        gridData.heightHint = 200;
        table.setLayoutData(gridData);

        TableViewerCreatorColumn column = new TableViewerCreatorColumn(tableViewerCreator);
        column.setTitle("Selection");
        column.setResizable(true);
        column.setModifiable(true);
        // column.setInitWeight(1);
        column.setWidth(100);
        column.setImageProvider(new IColumnImageProvider() {

            public Image getImage(Object bean) {
                return image;
            }
            
        });
        column.setBeanPropertyAccessors(new IBeanPropertyAccessors<DataObject, String>() {

            public String get(DataObject bean) {
                return bean.getLibelle();
            }

            public void set(DataObject bean, String value) {
                bean.setLibelle(value);
            }

        });

        column = new TableViewerCreatorColumn(tableViewerCreator);
        TableViewerCreatorColumn nameColumn = column;
        column.setTitle("Name");
        column.setResizable(true);
        column.setModifiable(true);
//        column.setSortable(true);
//        column.setOrderWithIgnoreCase(true);
        column.setMinimumWidth(10);
        column.setWeight(20);
        column.setImageProvider(new IColumnImageProvider() {

            public Image getImage(Object bean) {
                return image;
            }
            
        });
        column.setBeanPropertyAccessors(new IBeanPropertyAccessors<DataObject, String>() {

            public String get(DataObject bean) {
                return bean.getLibelle();
            }

            public void set(DataObject bean, String value) {
                bean.setLibelle(value);
            }

        });

        column = new TableViewerCreatorColumn(tableViewerCreator);
        column.setTitle("Integer Null Value");
        column.setModifiable(true);
        column.setSortable(true);
        column.setResizable(true);
        column.setBeanPropertyAccessors(new IBeanPropertyAccessors<DataObject, Integer>() {

            public Integer get(DataObject bean) {
                return bean.getIntegerValue2();
            }

            public void set(DataObject bean, Integer value) {
                bean.setIntegerValue2(value);
            }

        });
        column.setWidth(150);
        final String[] valueSet = new String[] { "xxx", "yyy", "zzz" };
        column.setCellEditor(new ComboBoxCellEditor(table, valueSet), new CellEditorValueAdapter() {

            public String getColumnText(CellEditor cellEditor, Object value) {
                String[] items = ((ComboBoxCellEditor) cellEditor).getItems();
                int index = (Integer) value;
                if (index >= 0 && index < items.length) {
                    return items[index];
                } else {
                    return "";
                }
            }
        });

        column = new TableViewerCreatorColumn(tableViewerCreator);
        column.setTitle("Boolean");
        column.setModifiable(false);
        column.setSortable(true);
        column.setResizable(true);
        column.setBeanPropertyAccessors(new IBeanPropertyAccessors<DataObject, Boolean>() {
            
            public Boolean get(DataObject bean) {
                return bean.isBool();
            }
            
            public void set(DataObject bean, Boolean value) {
                bean.setBool(value);
            }
            
        });
        column.setWidth(50);
        column.setTableEditorContent(new CheckboxTableEditorContent());
        
        column = new TableViewerCreatorColumn(tableViewerCreator);
        column.setTitle("Id");
        column.setModifiable(false);
        column.setResizable(true);
        column.setSortable(true);
        column.setMoveable(true);
        column.setWeight(80);
        column.setBeanPropertyAccessors(new IBeanPropertyAccessors<DataObject, Integer>() {

            public Integer get(DataObject bean) {
                return bean.getIntegerValue2();
            }

            public void set(DataObject bean, Integer value) {
                bean.setIntegerValue2(value);
            }

        });
        column.setTableEditorContent(new TableEditorContent() {

            public TableEditor createTableEditor(Table table) {
                TableEditor tableEditor = new TableEditor(table);
                return tableEditor;
            }

            public Control initialize(Table table, TableEditor tableEditor, TableViewerCreatorColumn currentColumn,
                    Object currentRowObject, Object currentCellValue) {
                Button button = new Button(table, SWT.PUSH);
                // Set attributes of the button
                button.setText(String.valueOf(currentCellValue));
                button.computeSize(SWT.DEFAULT, table.getItemHeight());

                // Set attributes of the editor
                tableEditor.grabHorizontal = true;
                tableEditor.minimumHeight = button.getSize().y;
                tableEditor.minimumWidth = button.getSize().x;
                return button;
            }

        });

        column = new TableViewerCreatorColumn(tableViewerCreator);
        column.setTitle("Id2");
        column.setModifiable(false);
        column.setResizable(true);
        column.setSortable(true);
        column.setWidth(50);
        column.setImageProvider(new IColumnImageProvider() {

            public Image getImage(Object bean) {
                return image;
            }
            
        });

        column.setBeanPropertyAccessors(new IBeanPropertyAccessors<DataObject, Integer>() {

            public Integer get(DataObject bean) {
                return bean.getIntegerValue2();
            }

            public void set(DataObject bean, Integer value) {
                bean.setIntegerValue2(value);
            }

        });
        
        column = new TableViewerCreatorColumn(tableViewerCreator);
        column.setTitle("Boolean2");
        column.setModifiable(false);
        column.setSortable(true);
        column.setResizable(true);
        column.setBeanPropertyAccessors(new IBeanPropertyAccessors<DataObject, Boolean>() {
            
            public Boolean get(DataObject bean) {
                return bean.isBool();
            }
            
            public void set(DataObject bean, Boolean value) {
                bean.setBool(value);
            }
            
        });
//        column.setWidth(20);
        column.setWeight(20);
        column.setMinimumWidth(50);
        column.setTableEditorContent(new CheckboxTableEditorContent());
        
        
        
//        column.setTableEditorContent(new TableEditorContent() {
//
//            public TableEditor createTableEditor(Table table) {
//                TableEditor tableEditor = new TableEditor(table);
//                return tableEditor;
//            }
//
//            public Control initialize(Table table, TableEditor tableEditor, TableViewerCreatorColumn currentColumn,
//                    Object currentRowObject, Object currentCellValue) {
//                Composite composite = new Composite(table, SWT.PUSH);
//                // Set attributes of the button
//                composite.setBackground(new Color(null, 255, 0, 0));
//                composite.setSize(100 * ((Integer) currentCellValue).intValue() / 100, table.getItemHeight());
//
//                // Set attributes of the editor
//                // tableEditor.grabHorizontal = true;
//                tableEditor.minimumHeight = composite.getSize().y;
//                tableEditor.horizontalAlignment = SWT.LEFT;
//                tableEditor.minimumWidth = composite.getSize().x;
//                return composite;
//            }
//
//        });

//        Listener eraseItemListener = new Listener() {
//
//            public void handleEvent(Event event) {
//
//                if ((event.detail & SWT.SELECTED) != 0) {
//
//                    GC gc = event.gc;
//                    
//
//                    Rectangle rect = event.getBounds();
//
//                    Color background = gc.getBackground();
//
//                    gc.setBackground(table.getDisplay().getSystemColor(SWT.COLOR_RED));
//
//                    // TODO: uncomment to see selection on linux gtk
//
//                    // ((TableItem)event.item).setBackground(null);
//
//                    gc.fillRectangle(rect);
//
//                    gc.setBackground(background);
//
//                    event.detail &= ~SWT.SELECTED;
//
//                }
//
//            }
//
//        };
//        table.addListener(SWT.EraseItem, eraseItemListener);

        Button buttonSelection = new Button(shell1, SWT.PUSH);
        buttonSelection.setText("buttonSelection");
        buttonSelection.addSelectionListener(new SelectionListener() {

            public void widgetDefaultSelected(SelectionEvent e) {
                // TODO Auto-generated method stub
                
            }

            public void widgetSelected(SelectionEvent e) {
                table.setSelection(1);
            }
            
        });
        
        Button buttonHighlightRow = new Button(shell1, SWT.PUSH);
        buttonHighlightRow.setText("buttonHighlightRow");
        buttonHighlightRow.addSelectionListener(new SelectionListener() {
            
            public void widgetDefaultSelected(SelectionEvent e) {
                // TODO Auto-generated method stub
                
            }
            
            public void widgetSelected(SelectionEvent e) {
                TableItem tableItem1 = table.getItem(0);
                tableItem1.setBackground(table.getDisplay().getSystemColor(SWT.COLOR_RED));
                tableItem1.setForeground(table.getDisplay().getSystemColor(SWT.COLOR_BLUE));
//                tableViewerCreator.getTableViewer().refresh();
            }
            
        });
        
        
        Button buttonHighlightCell = new Button(shell1, SWT.PUSH);
        buttonHighlightCell.setText("buttonHighlightCell");
        buttonHighlightCell.addSelectionListener(new SelectionListener() {
            
            public void widgetDefaultSelected(SelectionEvent e) {
                // TODO Auto-generated method stub
                
            }
            
            public void widgetSelected(SelectionEvent e) {
                TableItem tableItem2 = table.getItem(1);
                tableItem2.setBackground(table.getDisplay().getSystemColor(SWT.COLOR_GREEN));
                tableItem2.setBackground(1, table.getDisplay().getSystemColor(SWT.COLOR_GREEN));
                tableItem2.setForeground(1, table.getDisplay().getSystemColor(SWT.COLOR_BLUE));
//                tableViewerCreator.getTableViewer().refresh();
            }
            
        });
        
        Button buttonHighlightMultipleCell = new Button(shell1, SWT.PUSH);
        buttonHighlightMultipleCell.setText("buttonHighlightMultipleCell");
        buttonHighlightMultipleCell.addSelectionListener(new SelectionListener() {
            
            public void widgetDefaultSelected(SelectionEvent e) {
                // TODO Auto-generated method stub
                
            }
            
            public void widgetSelected(SelectionEvent e) {
                TableItem tableItem2 = table.getItem(1);
                tableItem2.setBackground(table.getDisplay().getSystemColor(SWT.COLOR_YELLOW));
                tableItem2.setBackground(0, table.getDisplay().getSystemColor(SWT.COLOR_DARK_MAGENTA));
                tableItem2.setForeground(0, table.getDisplay().getSystemColor(SWT.COLOR_DARK_BLUE));
                tableItem2.setBackground(1, table.getDisplay().getSystemColor(SWT.COLOR_GREEN));
                tableItem2.setForeground(1, table.getDisplay().getSystemColor(SWT.COLOR_BLUE));
//                tableViewerCreator.getTableViewer().refresh();
            }
            
        });
        

        Button buttonBGTable = new Button(shell1, SWT.PUSH);
        buttonBGTable.setText("buttonBGTable");
        buttonBGTable.addSelectionListener(new SelectionListener() {
            
            public void widgetDefaultSelected(SelectionEvent e) {
                // TODO Auto-generated method stub
                
            }
            
            public void widgetSelected(SelectionEvent e) {
                table.setBackground(table.getDisplay().getSystemColor(SWT.COLOR_CYAN));
                table.setBackground(table.getDisplay().getSystemColor(SWT.COLOR_CYAN));
            }
            
        });
        
        Button buttonClearTable = new Button(shell1, SWT.PUSH);
        buttonClearTable.setText("buttonClearTable");
        buttonClearTable.addSelectionListener(new SelectionListener() {
            
            public void widgetDefaultSelected(SelectionEvent e) {
                // TODO Auto-generated method stub
                
            }
            
            public void widgetSelected(SelectionEvent e) {
                table.setBackground(null);
                table.setForeground(null);
            }
            
        });
        
        Button buttonWhiteTable = new Button(shell1, SWT.PUSH);
        buttonWhiteTable.setText("buttonWhiteTable");
        buttonWhiteTable.addSelectionListener(new SelectionListener() {
            
            public void widgetDefaultSelected(SelectionEvent e) {
                // TODO Auto-generated method stub
                
            }
            
            public void widgetSelected(SelectionEvent e) {
                table.setBackground(table.getDisplay().getSystemColor(SWT.COLOR_WHITE));
                table.setForeground(table.getDisplay().getSystemColor(SWT.COLOR_BLACK));
            }
            
        });
        
//        tableViewerCreator.setDefaultSort(nameColumn, SORT.DESC);
        
        list = new ArrayList<DataObject>();
        Random random = new Random();
        for (int i = 0; i < 2; i++) {
            DataObject listObject2 = new DataObject();
            listObject2.setPrimaryIntegerValue(i);
            listObject2.setIntegerValue2(random.nextInt(100));
            list.add(listObject2);
        }
        tableViewerCreator.init(list);

        shell1.setSize(800, 500);
        shell1.open();

        while (!shell1.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
        display.dispose();
    }

}
