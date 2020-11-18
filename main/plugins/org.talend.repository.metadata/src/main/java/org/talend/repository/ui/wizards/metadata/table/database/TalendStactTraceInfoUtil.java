package org.talend.repository.ui.wizards.metadata.table.database;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

import org.talend.commons.exception.ExceptionHandler;
import org.talend.commons.exception.PersistenceException;
import org.talend.core.model.properties.ConnectionItem;
import org.talend.core.model.properties.Item;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.core.repository.model.ProxyRepositoryFactory;

public class TalendStactTraceInfoUtil {

    public static boolean PRINT_STATCK_TRACE = Boolean.getBoolean("talend.studio.database.printStacktrace");

    public static void printConnectionIfo(ConnectionItem connectionItem, String info) {
        if (PRINT_STATCK_TRACE) {
            boolean connectionItemIsNull = true;
            boolean propertyIsNull = true;
            boolean eResourceIsNull = true;
            if (connectionItem != null) {
                connectionItemIsNull = false;
                if (connectionItem.getProperty() != null) {
                    propertyIsNull = false;
                    if (connectionItem.getProperty().eResource() != null) {
                        eResourceIsNull = false;
                    }
                }
            }
            ExceptionHandler.log("@" + info + ", Conntection Item is null:" + connectionItemIsNull
                    + ", Connection property is null:" + propertyIsNull + ", EResource is null:" + eResourceIsNull);
            if (connectionItemIsNull || propertyIsNull || eResourceIsNull) {
                dumpThreadDump();
            }
        }
    }

    public static ConnectionItem checkConnectionItemResource(ConnectionItem item, String info) {
        if (PRINT_STATCK_TRACE) {
            if (item != null && item.getProperty() != null && item.getProperty().eResource() == null) {
                try {
                    IRepositoryViewObject reloadedObject = ProxyRepositoryFactory.getInstance()
                            .getSpecificVersion(item.getProperty().getId(), item.getProperty().getVersion(), true);
                    if (reloadedObject != null) {
                        Item reloadeditem = reloadedObject.getProperty().getItem();
                        if (reloadeditem instanceof ConnectionItem) {
                            ConnectionItem reloadedConnectionItem = (ConnectionItem) reloadeditem;
                            ExceptionHandler.log("@ Reload connection item successfully." + info);
                            return reloadedConnectionItem;
                        } else {
                            ExceptionHandler.log("@ the item is not ConnectionItem:" + reloadedObject.getRepositoryObjectType());
                        }
                    } else {
                        ExceptionHandler.log("@ Can't load property by id:" + item.getProperty().getId() + ", version:"
                                + item.getProperty().getVersion());
                    }
                } catch (PersistenceException ex) {
                    ExceptionHandler.process(ex);
                }

            }
        }
        return null;
    }

    public static void dumpThreadDump() {
        ThreadMXBean threadMxBean = ManagementFactory.getThreadMXBean();
        StringBuilder sb = new StringBuilder();
        for (ThreadInfo ti : threadMxBean.dumpAllThreads(true, true)) {
            sb.append(ti.toString());
        }
        ExceptionHandler.log("@" + sb.toString());
    }
}
