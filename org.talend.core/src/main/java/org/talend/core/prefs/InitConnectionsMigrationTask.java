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
package org.talend.core.prefs;

import java.util.List;

import org.talend.core.CorePlugin;
import org.talend.core.model.general.ConnectionBean;
import org.talend.core.model.migration.AbstractMigrationTask;
import org.talend.core.model.migration.IWorkspaceMigrationTask;

/**
 * DOC smallet class global comment. Detailled comment <br/>
 * 
 * $Id: talend.epf 1 2006-09-29 17:06:40 +0000 (ven., 29 sept. 2006) nrousseau $
 * 
 */
public class InitConnectionsMigrationTask extends AbstractMigrationTask implements IWorkspaceMigrationTask {

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.core.model.migration.IMigrationTask#execute()
     */
    public boolean execute() {
        PreferenceManipulator prefManipulator = new PreferenceManipulator(CorePlugin.getDefault().getPreferenceStore());

        List<ConnectionBean> toReturn = prefManipulator.readConnections();

        if (toReturn.isEmpty()) {
            if (prefManipulator.getLastUser() != null && prefManipulator.getLastUser().length() > 0) {
                ConnectionBean recup = ConnectionBean.getDefaultConnectionBean();
                recup.setUser(prefManipulator.getLastUser());
                recup.setComplete(true);
                toReturn.add(recup);

                prefManipulator.saveConnections(toReturn);

                prefManipulator.setLastUser(""); //$NON-NLS-1$
                prefManipulator.saveUsers(new String[] {});
            }
        }
        return true;
    }

}
