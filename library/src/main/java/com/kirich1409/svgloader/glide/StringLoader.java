/*
 * Copyright 2018 Kirill Rozov
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.kirich1409.svgloader.glide;

import android.support.annotation.NonNull;

import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import com.bumptech.glide.load.model.UnitModelLoader;

@SuppressWarnings("deprecation")
final class StringLoader extends UnitModelLoader<String> {

    @Override
    public boolean handles(@NonNull String s) {
        return s.contains("<svg");
    }

    static class Factory implements ModelLoaderFactory<String, String> {

        private static final StringLoader.Factory FACTORY = new StringLoader.Factory();

        public static StringLoader.Factory getInstance() {
            return FACTORY;
        }

        @NonNull
        @Override
        public ModelLoader<String, String> build(@NonNull MultiModelLoaderFactory multiFactory) {
            return StringLoader.getInstance();
        }

        @Override
        public void teardown() {
            // Do nothing.
        }
    }
}
