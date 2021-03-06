/**
 *    Copyright (C) 2010 - 2014 VREM Software Development <VREMSoftwareDevelopment@gmail.com>
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package ca.travelagency.components.fields;

import java.util.Collections;
import java.util.Iterator;

import org.apache.wicket.extensions.ajax.markup.html.autocomplete.DefaultCssAutoCompleteTextField;

import ca.travelagency.utils.StringUtils;

import com.google.common.collect.Lists;

public class ChangeDepartureField extends DefaultCssAutoCompleteTextField<String> {
	private static final long serialVersionUID = 1L;
	private String[] choices;

	public ChangeDepartureField(String id) {
		super(id, null);
		choices = getLocalizer().getString("choices", this).split(",");
	}

	@Override
	protected Iterator<String> getChoices(String input) {
		if (StringUtils.isEmpty(input)) {
			return Collections.<String>emptyList().iterator();
		}
		return Lists.newArrayList(choices).iterator();
	}
}