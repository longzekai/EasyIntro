/*
 * Copyright 2016 Alireza Eskandarpour Shoferi
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

package io.github.meness.easyintro.interfaces;

import android.support.annotation.AnimRes;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;

import io.github.meness.easyintro.EasyIntro;
import io.github.meness.easyintro.EasyIntroFragment;

/**
 * following method may be configured multiple times through {@link EasyIntro#initIntro()} and/or {@link EasyIntroFragment}
 */
public interface IConfig {
    void withPageIndicatorVisibility(boolean b);

    // disable indicator for specific slide
    void withRightIndicatorDisabled(boolean b, @NonNull Class slide);

    // disable indicator for specific slide
    void withLeftIndicatorDisabled(boolean b, @NonNull Class slide);

    void withBothIndicatorsDisabled(boolean b, Class slide);

    void withNextSlide(boolean smoothScroll);

    void withPreviousSlide(boolean smoothScroll);

    void withSlideTo(int page, boolean smoothScroll);

    Fragment getCurrentSlide();

    /**
     * replace an overlay slide
     *
     * @param slide           slide you want to replace as an overlay slide
     * @param container       resource id
     * @param fragmentManager fragment manager
     * @see #withOverlaySlide(Fragment, int, FragmentManager, int, int)
     * @see #withOverlaySlide(Fragment, int, FragmentManager, int, int, int, int)
     * @see IConfigOnce#withOverlaySlideAnimation(int, int, int, int) for defining once
     */
    void withOverlaySlide(Fragment slide, @IdRes int container, FragmentManager fragmentManager);

    /**
     * replace an overlay slide with enter and exit animations
     *
     * @param slide           slide you want to replace as an overlay slide
     * @param container       resource id
     * @param fragmentManager fragment manager
     * @param enter           anim resource id
     * @param exit            anim resource id
     * @see #withOverlaySlide(Fragment, int, FragmentManager)
     * @see #withOverlaySlide(Fragment, int, FragmentManager, int, int, int, int)
     * @see IConfigOnce#withOverlaySlideAnimation(int, int, int, int) for defining once
     */
    void withOverlaySlide(Fragment slide, @IdRes int container, FragmentManager fragmentManager, @AnimRes int enter,
                          @AnimRes int exit);

    /**
     * replace an overlay slide with enter, exit, pop enter and pop exit animations
     *
     * @param slide           slide you want to replace as an overlay slide
     * @param container       resource id
     * @param fragmentManager fragment manager
     * @param enter           anim resource id
     * @param exit            anim resource id
     * @param popEnter        anim resource id
     * @param popExit         anim resource id
     * @see #withOverlaySlide(Fragment, int, FragmentManager)
     * @see #withOverlaySlide(Fragment, int, FragmentManager, int, int)
     * @see IConfigOnce#withOverlaySlideAnimation(int, int, int, int) for defining oncece
     */
    void withOverlaySlide(Fragment slide, @IdRes int container, FragmentManager fragmentManager, @AnimRes int enter,
                          @AnimRes int exit, @AnimRes int popEnter, @AnimRes int popExit);

    /**
     * replace an overlay slide with enter, exit, pop enter and pop exit animations and also shared element
     *
     * @param slide           slide you want to replace as an overlay slide
     * @param container       resource id
     * @param fragmentManager fragment manager
     * @param enter           anim resource id
     * @param exit            anim resource id
     * @param popEnter        anim resource id
     * @param popExit         anim resource id
     * @param sharedElement   a View in a disappearing Fragment to match with a View in an
     *                        appearing Fragment.
     * @param transitionName  the transitionName for a View in an appearing Fragment to match to the shared
     *                        element.
     * @see #withOverlaySlide(Fragment, int, FragmentManager)
     * @see #withOverlaySlide(Fragment, int, FragmentManager, int, int)
     * @see #withOverlaySlide(Fragment, int, FragmentManager, int, int, int, int)
     * @see IConfigOnce#withOverlaySlideAnimation(int, int, int, int) for defining oncece
     */
    void withOverlaySlide(Fragment slide, @IdRes int container, FragmentManager fragmentManager, @AnimRes int enter,
                          @AnimRes int exit, @AnimRes int popEnter, @AnimRes int popExit, View sharedElement, String transitionName);

    void withSlideTo(Class slideClass, boolean smoothScroll);
}
