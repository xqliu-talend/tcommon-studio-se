// ============================================================================
//
// Copyright (C) 2006-2012 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.designer.core.ui.views.properties;

import org.talend.core.model.process.Element;

/**
 * DOC qzhang class global comment. Detailled comment.
 */
public interface IComponentSettingsView {

    String ID = "org.talend.designer.core.ui.views.properties.ComponentSettingsView"; //$NON-NLS-1$

    void cleanDisplay();

    void setElement(Element element);
}
