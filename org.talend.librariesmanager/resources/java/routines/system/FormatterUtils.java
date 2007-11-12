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
package routines.system;

public class FormatterUtils {
    public static String format_Date(java.util.Date date, String pattern) {
        java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat(pattern);
        return simpleDateFormat.format(date);
    }
}
