/*
 * Copyright (c) 2020 Broadcom.
 * The term "Broadcom" refers to Broadcom Inc. and/or its subsidiaries.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *    Broadcom, Inc. - initial API and implementation
 *
 */

package org.eclipse.lsp.cobol.core.preprocessor.delegates;

import lombok.NonNull;
import org.antlr.v4.runtime.BufferedTokenStream;
import org.apache.commons.lang3.tuple.Pair;
import org.eclipse.lsp.cobol.core.CobolPreprocessorLexer;
import org.eclipse.lsp.cobol.core.model.CopybookUsage;
import org.eclipse.lsp.cobol.service.CopybookProcessingMode;

import java.util.Deque;
import java.util.List;

/** A factory for {@link GrammarPreprocessorListener} */
public interface GrammarPreprocessorListenerFactory {
  /**
   * Create a new {@link GrammarPreprocessorListenerImpl} for pre-processing of a COBOL text with
   * the grammar
   *
   * @param uri - URI of the document
   * @param tokens - a stream of tokens by {@link CobolPreprocessorLexer}
   * @param copybookStack - a stack representing the copybook hierarchy
   * @param copybookProcessingMode - settings of copybook processing
   * @param recursiveReplaceStmtStack - a stack representing the replace clause hierarchy
   *
   * @return a new listener
   */
  GrammarPreprocessorListenerImpl create(
      @NonNull String uri,
      @NonNull BufferedTokenStream tokens,
      @NonNull Deque<CopybookUsage> copybookStack,
      @NonNull CopybookProcessingMode copybookProcessingMode,
      @NonNull Deque<List<Pair<String, String>>> recursiveReplaceStmtStack);
}
