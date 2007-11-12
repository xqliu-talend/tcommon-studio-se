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
package org.talend.designer.runprocess;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.talend.core.model.process.IContext;
import org.talend.core.model.process.IProcess;
import org.talend.core.model.process.ITargetExecutionConfig;
import org.talend.designer.core.ISyntaxCheckableEditor;

/**
 * DOC qian class global comment. Detailled comment <br/>
 * 
 * $Id: talend-code-templates.xml 1 2006-09-29 17:06:40 +0000 (星期五, 29 九月 2006) nrousseau $
 * 
 */
public interface IProcessor {

    public static final int NO_STATISTICS = -1;

    public static final int NO_TRACES = -1;

    public static final int WATCH_LIMITED = -1;

    public static final int WATCH_ALLOWED = 1;

    public static final int STATES_EDIT = 0;

    public static final int STATES_RUNTIME = 1;

    /**
     * generate the code of the current Process.
     * 
     * @param statistics generate with statistics option ?
     * @param trace generate with trace option ?
     * @param context generate also the context file ?
     * @throws ProcessorException
     */
    public void generateCode(boolean statistics, boolean trace, boolean context) throws ProcessorException;

    /**
     * Run the process.
     * 
     * To use this method, the code must be generated first. (for compatibility, if the code has never been generated,
     * it will generated once)
     * 
     * This method does not allow to cancel initialization of process launching by user (IProgressMonitor) and can't
     * send messages to console (IProcessMessageManager).
     * 
     * @param statisticsPort TCP port used to get statistics from the process, <code>NO_STATISTICS</code> if none.
     * @param tracePort TCP port used to get trace from the process, <code>NO_TRACE</code> if none.
     * @param context The context to be used.
     * @param watchPort
     * @return The running process.
     * @throws ProcessorException Process failed.
     */
    public Process run(int statisticsPort, int tracePort, String watchParam) throws ProcessorException;

    /**
     * 
     * Run the process.
     * 
     * To use this method, the code must be generated first. (for compatibility, if the code has never been generated,
     * it will generated once)
     * 
     * This method allows to cancel initialization of process launching by user, by specifying an IProgressMonitor.
     * 
     * @param statisticsPort
     * @param tracePort
     * @param watchParam
     * @param monitor progress monitor to cancel initialization of process
     * @param processMessageManager manager to add messages into console
     * @return
     * @throws ProcessorException
     */
    public Process run(int statisticsPort, int tracePort, String watchParam, IProgressMonitor monitor,
            IProcessMessageManager processMessageManager) throws ProcessorException;

    // to use "debug", the code must be generated first.
    // (for compatibility, if the code has never been generated, it will generated once)
    public ILaunchConfiguration debug() throws ProcessorException;

    /**
     * getter the code context.
     * 
     * @return
     */
    public String getCodeContext();

    /**
     * Getter for codePath.
     * 
     * @return the codePath
     */
    public IPath getCodePath();

    /**
     * Getter for contextPath.
     * 
     * @return the contextPath
     */
    public IPath getContextPath();

    /**
     * getter the code project.
     * 
     * @return
     */
    public IProject getCodeProject();

    /**
     * Return line number where stands specific node in code generated.
     * 
     * @param nodeName
     */
    public int getLineNumber(String nodeName);

    /**
     * Get the interpreter for each kinds of language.
     * 
     * yzhang Comment method "getInterpreter".
     * 
     * @return
     * @throws ProcessorException
     */
    public String getInterpreter() throws ProcessorException;

    /**
     * Used to set a specific interpreter.
     * 
     * @return
     */
    public void setInterpreter(String interpreter);

    /**
     * Used to get the routine path.
     * 
     * @return
     */
    public String getLibraryPath() throws ProcessorException;

    /**
     * Used to set a specific routine path.
     * 
     * @return
     */
    public void setLibraryPath(String libraryPath);

    /**
     * Used to get the routine path.
     * 
     * @return
     */
    public String getCodeLocation() throws ProcessorException;

    /**
     * Used to set a specific routine path.
     * 
     * @return
     */
    public void setCodeLocation(String codeLocation);

    /**
     * Get the processor type, e.g. java processor, perl processor.
     * 
     * yzhang Comment method "getProcessorType".
     * 
     * @return
     */
    public String getProcessorType();

    /**
     * Set the processor's current states.
     * 
     * yzhang Comment method "getProcessorStates".
     * 
     * @return
     */
    public void setProcessorStates(int states);

    /**
     * Add the Syntax Checkable Editor for refresh format of the code wihtin the editor, and also for error check.
     * 
     * yzhang Comment method "addSyntaxCheckableEditor".
     * 
     * @param editor
     */
    public void setSyntaxCheckableEditor(ISyntaxCheckableEditor editor);

    /**
     * Get Current type name for launching.
     * 
     * yzhang Comment method "getTypeName".
     */
    public String getTypeName();

    /**
     * Save lauch configuration.
     * 
     * @return
     * @throws CoreException
     */
    public Object saveLaunchConfiguration() throws CoreException;

    public String[] getCommandLine(boolean externalUse, int statOption, int traceOption, String... codeOptions);

    public void setContext(IContext context);

    public void setTargetExecutionConfig(ITargetExecutionConfig serverConfiguration);

    public String getTargetPlatform();

    public void setTargetPlatform(String targetPlatform);
    
    public void initPath() throws ProcessorException;

    public IProcess getProcess();

    public IContext getContext();
}
