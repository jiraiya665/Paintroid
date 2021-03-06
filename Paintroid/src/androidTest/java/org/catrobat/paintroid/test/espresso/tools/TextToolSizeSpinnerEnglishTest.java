/**
 *  Paintroid: An image manipulation application for Android.
 *  Copyright (C) 2010-2015 The Catrobat Team
 *  (<http://developer.catrobat.org/credits>)
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Affero General Public License as
 *  published by the Free Software Foundation, either version 3 of the
 *  License, or (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 *  GNU Affero General Public License for more details.
 *
 *  You should have received a copy of the GNU Affero General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.catrobat.paintroid.test.espresso.tools;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.catrobat.paintroid.MainActivity;
import org.catrobat.paintroid.R;
import org.catrobat.paintroid.test.espresso.rtl.util.RtlActivityTestRule;
import org.catrobat.paintroid.tools.ToolType;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Locale;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isClickable;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

import static org.catrobat.paintroid.test.espresso.util.UiMatcher.withIndex;
import static org.catrobat.paintroid.test.espresso.util.wrappers.ToolBarViewInteraction.onToolBarView;
import static org.junit.Assert.assertEquals;

@RunWith(AndroidJUnit4.class)
public class TextToolSizeSpinnerEnglishTest {
	private static final Locale ENGLISHLOCALE =
			new Locale("en");

	@Rule
	public ActivityTestRule<MainActivity> lunchActivityRule =
			new RtlActivityTestRule<>(MainActivity.class, "en");

	@Test
	public void testEnglishNumberFormatOfSizeSpinner() throws Exception {
		assertEquals(Locale.getDefault().getDisplayLanguage(), ENGLISHLOCALE.getDisplayLanguage());

		onToolBarView()
				.performSelectTool(ToolType.TEXT);
		onView(withId(R.id.pocketpaint_text_tool_dialog_spinner_text_size))
				.check(matches(isClickable()))
				.perform(click());

		onView(withIndex(withId(android.R.id.text1), 0))
				.check(matches(withText("20px")));

		onView(withIndex(withId(android.R.id.text1), 1))
				.check(matches(withText("30px")));

		onView(withIndex(withId(android.R.id.text1), 2))
				.check(matches(withText("40px")));

		onView(withIndex(withId(android.R.id.text1), 3))
				.check(matches(withText("60px")));
	}
}
