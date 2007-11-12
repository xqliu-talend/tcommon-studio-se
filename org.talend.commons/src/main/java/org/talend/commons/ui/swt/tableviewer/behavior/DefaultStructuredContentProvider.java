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
package org.talend.commons.ui.swt.tableviewer.behavior;

import java.util.Collection;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.talend.commons.ui.swt.tableviewer.TableViewerCreator;

/**
 * 
 * Default implementation of <code>IStructuredContentProvider</code> used by <code>TableViewerCreator</code>. <br/>
 * 
 * $Id$
 * 
 * @see <code>IStructuredContentProvider</code>
 */
public class DefaultStructuredContentProvider implements IStructuredContentProvider {

    TableViewerCreator tableViewerCreator;

    public DefaultStructuredContentProvider(TableViewerCreator tableViewerCreator) {
        super();
        this.tableViewerCreator = tableViewerCreator;
    }

    public Object[] getElements(Object inputElement) {
        return (Object[]) ((Collection) inputElement).toArray();
    }

    public void dispose() {
    }

    public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
    }

}
