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
package org.talend.commons.ui.swt.tableviewer.selection;

import org.talend.commons.ui.swt.tableviewer.TableViewerCreator;

/**
 * DOC amaumont class global comment. Detailled comment <br/>
 * 
 * $Id$
 * 
 */
public class LineSelectionEvent {

    /**
     * Indicate if the current line selection has been made by calling a selection method of <code>Table</code> or
     * <code>TableViewer</code>, unlike a selection with keyboard and/or mouse.
     */
    public boolean selectionByMethod;

    public TableViewerCreator source;
}
