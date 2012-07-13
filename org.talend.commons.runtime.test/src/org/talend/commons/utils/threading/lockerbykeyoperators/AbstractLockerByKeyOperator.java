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
package org.talend.commons.utils.threading.lockerbykeyoperators;

import org.talend.commons.utils.threading.LockerByKey;
import org.talend.commons.utils.threading.threadsafetester.IThreadSafetyOperator;


public abstract class AbstractLockerByKeyOperator implements IThreadSafetyOperator {

    protected LockerByKey locker;

    protected int nOperationsByOperator;

    protected ResultContainer resultContainer;

    private static int[] notThreadSafeCounters;

    public AbstractLockerByKeyOperator() {
        super();
    }

    /**
     * Sets the locker.
     * 
     * @param locker the locker to set
     */
    public void setLocker(LockerByKey locker) {
        this.locker = locker;
    }

    /**
     * Sets the nOperationsByOperator.
     * 
     * @param nOperationsByOperator the nOperationsByOperator to set
     */
    public void setnOperationsByOperator(int nOperationsByOperator) {
        this.nOperationsByOperator = nOperationsByOperator;
        notThreadSafeCounters = new int[nOperationsByOperator];
    }

    /**
     * Sets the resultContainer.
     * 
     * @param resultContainer the resultContainer to set
     */
    public void setResultContainer(ResultContainer resultContainer) {
        this.resultContainer = resultContainer;
    }

    public static int getNotThreadSafeCounter() {
        int counter = 0;
        for (int i = 0; i < notThreadSafeCounters.length; i++) {
            counter += notThreadSafeCounters[i];
        }
        return counter;
    }

    protected void incrementNotThreadSafeCounter(int i) {
        notThreadSafeCounters[i]++;
    }


}
