// ============================================================================
//
// Copyright (C) 2006-2019 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.commons.utils;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.eclipse.core.runtime.Platform;
import org.talend.commons.exception.ExceptionHandler;
import org.talend.utils.io.FilesUtils;

public class SharedStudioUtils {

	public static final String FILE_EXTRA_FEATURE_INDEX = "extra_feature.index"; //$NON-NLS-1$

	public static final String SIGNATURE_FILE_NAME_SUFFIX = ".sig"; //$NON-NLS-1$

	public static boolean updateExtraFeatureFile() {
		File userConfigFolder = new File(Platform.getConfigurationLocation().getURL().getPath());
		File studioConfigFolder = new File(Platform.getInstallLocation().getURL().getPath(), "configuration");//$NON-NLS-1$
		if (!userConfigFolder.getAbsolutePath().equals(studioConfigFolder.getAbsolutePath())) {
			File studioExtraFile = new File(studioConfigFolder, FILE_EXTRA_FEATURE_INDEX);
			File studioExtraSignFile = new File(studioConfigFolder,
					FILE_EXTRA_FEATURE_INDEX + SIGNATURE_FILE_NAME_SUFFIX);
			File userExtraFile = new File(userConfigFolder, FILE_EXTRA_FEATURE_INDEX);
			File userExtraSignFile = new File(userConfigFolder, FILE_EXTRA_FEATURE_INDEX + SIGNATURE_FILE_NAME_SUFFIX);
			boolean isNeedUpdate = false;
			if (!studioExtraSignFile.exists() && userExtraSignFile.exists()) {
				userExtraSignFile.delete();
				if (userExtraFile.exists()) {
					userExtraFile.delete();
				}
				return true;
			} else if (studioExtraSignFile.exists() && !userExtraSignFile.exists()) {
				isNeedUpdate = true;
			} else if (studioExtraSignFile.exists() && userExtraSignFile.exists()) {
				try {
					List<String> studioExtraSignatureContent = FilesUtils
							.getContentLines(studioExtraSignFile.getAbsolutePath());
					List<String> userExtraSignatureContent = FilesUtils
							.getContentLines(userExtraSignFile.getAbsolutePath());
					if (studioExtraSignatureContent.size() != userExtraSignatureContent.size()) {
						isNeedUpdate = true;
					} else {
						for (int i = 0; i < studioExtraSignatureContent.size(); i++) {
							if (!studioExtraSignatureContent.get(i).equals(userExtraSignatureContent.get(i))) {
								isNeedUpdate = true;
								break;
							}
						}
					}
				} catch (IOException ex) {
					ExceptionHandler.process(ex);
				}
			}
			if (isNeedUpdate) {
				try {
					FilesUtils.copyFile(studioExtraFile, userExtraFile);
					FilesUtils.copyFile(studioExtraSignFile, userExtraSignFile);
				} catch (IOException ex) {
					ExceptionHandler.process(ex);
				}
				return true;
			}
		}
		return false;
	}
}
