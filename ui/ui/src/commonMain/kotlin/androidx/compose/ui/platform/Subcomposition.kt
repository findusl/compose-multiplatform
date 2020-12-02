/*
 * Copyright 2020 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package androidx.compose.ui.platform

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Composition
import androidx.compose.runtime.CompositionReference
import androidx.compose.runtime.ExperimentalComposeApi
import androidx.compose.ui.node.LayoutNode
import androidx.compose.ui.util.annotation.MainThread

internal expect fun actualSubcomposeInto(
    container: LayoutNode,
    parent: CompositionReference,
    composable: @Composable () -> Unit
): Composition

@OptIn(ExperimentalComposeApi::class)
@MainThread
fun subcomposeInto(
    container: LayoutNode,
    parent: CompositionReference,
    composable: @Composable () -> Unit
): Composition = actualSubcomposeInto(container, parent, composable)