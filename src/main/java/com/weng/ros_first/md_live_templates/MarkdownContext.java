// Copyright 2000-2022 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package com.weng.ros_first.md_live_templates;

import com.intellij.codeInsight.template.TemplateActionContext;
import com.intellij.codeInsight.template.TemplateContextType;
import org.jetbrains.annotations.NotNull;

public class MarkdownContext extends TemplateContextType {

	protected MarkdownContext() {
		super("MARKDOWN", "Markdown");
	}

	@Override
	public boolean isInContext(@NotNull TemplateActionContext templateActionContext) {
		return templateActionContext.getFile().getName().endsWith(".md");
	}

}
