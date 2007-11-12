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
package org.talend.repository.localprovider.ui.actions;

import org.apache.log4j.Logger;
import org.eclipse.jface.action.Action;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.talend.commons.exception.MessageBoxExceptionHandler;
import org.talend.commons.exception.PersistenceException;
import org.talend.repository.localprovider.i18n.Messages;
import org.talend.repository.localprovider.model.LocalRepositoryFactory;
import org.talend.repository.ui.views.IRepositoryView;

/**
 * DOC smallet class global comment. Detailled comment <br/>
 * 
 * $Id: talend.epf 1 2006-09-29 17:06:40 +0000 (ven., 29 sept. 2006) nrousseau $
 * 
 */
public class ReloadSystemRoutinesAction extends Action {

    private static Logger log = Logger.getLogger(ReloadSystemRoutinesAction.class);

    public ReloadSystemRoutinesAction() {
        super();
        this.setActionDefinitionId("reloadSystemRoutines"); //$NON-NLS-1$
    }

    @Override
    public void run() {
        try {
            LocalRepositoryFactory.getInstance().synchronizeRoutines(null);
            IWorkbenchPage iwp = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
            IRepositoryView viewPart = (IRepositoryView) iwp.findView(IRepositoryView.VIEW_ID);
            viewPart.refresh();
            log.info(Messages.getString("ReloadSystemRoutinesAction.logInfo.sysRoutinesSuccessfullyReloaded")); //$NON-NLS-1$
        } catch (PersistenceException e) {
            MessageBoxExceptionHandler.process(e);
        }
    }

}
