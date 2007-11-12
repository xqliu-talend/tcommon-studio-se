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
package org.talend.librariesmanager.ui.actions;

import org.eclipse.jface.action.Action;
import org.talend.commons.ui.image.EImage;
import org.talend.commons.ui.image.ImageProvider;
import org.talend.core.CorePlugin;
import org.talend.librariesmanager.i18n.Messages;

/**
 * DOC smallet class global comment. Detailled comment <br/>
 * 
 * $Id: CheckModulesAction.java 1811 2007-02-05 03:29:11Z qzhang $
 * 
 */
public class CheckModulesAction extends Action {

    public CheckModulesAction() {
        super();
        setText(Messages.getString("CheckModulesAction.CheckRefrshBtn.Text")); //$NON-NLS-1$
        setToolTipText(Messages.getString("CheckModulesAction.CheckRefrshBtn.Text")); //$NON-NLS-1$
        setImageDescriptor(ImageProvider.getImageDesc(EImage.REFRESH_ICON));
        this.setActionDefinitionId("refreshModules");
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.action.Action#run()
     */
    @Override
    public void run() {
        CorePlugin.getDefault().getLibrariesService().resetModulesNeeded();
    }

}
