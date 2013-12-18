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
package ca.travelagency.config;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CompanyTest {
	private static final String BIG_NAME_LOWER = "big name";
	private static final String BIG_NAME_EXPECTED = "Big Name";
	private static final String BIG_NAME_UPPER = "BIG NAME";
	private Company fixture;

	@Before
	public void setUp() throws Exception {
		fixture = new Company();
	}

	@Test
	public void testEquals() throws Exception {
		Company expected = new Company();
		Company actual = new Company();

		Assert.assertNotSame(expected, actual);
		Assert.assertTrue(expected.equals(actual));
	}

	@Test
	public void testFromUpperToCamelCase() {
		fixture.setName(BIG_NAME_UPPER);
		fixture.setAddress(BIG_NAME_UPPER);
		fixture.setCity(BIG_NAME_UPPER);
		fixture.setProvince(BIG_NAME_UPPER);
		fixture.setCountry(BIG_NAME_UPPER);

		validateCamelCase();
	}

	private void validateCamelCase() {
		Assert.assertEquals(BIG_NAME_EXPECTED, fixture.getName());
		Assert.assertEquals(BIG_NAME_EXPECTED, fixture.getAddress());
		Assert.assertEquals(BIG_NAME_EXPECTED, fixture.getProvince());
		Assert.assertEquals(BIG_NAME_EXPECTED, fixture.getCity());
		Assert.assertEquals(BIG_NAME_EXPECTED, fixture.getCountry());
	}

	@Test
	public void testFromLowerToCamelCase() {
		fixture.setName(BIG_NAME_LOWER);
		fixture.setAddress(BIG_NAME_LOWER);
		fixture.setCity(BIG_NAME_LOWER);
		fixture.setProvince(BIG_NAME_LOWER);
		fixture.setCountry(BIG_NAME_LOWER);

		validateCamelCase();
	}

	@Test
	public void testPostalCodeToUpperCase() {
		fixture.setPostalCode(BIG_NAME_LOWER);
		Assert.assertEquals(BIG_NAME_UPPER, fixture.getPostalCode());
	}

	@Test
	public void testPhoneNumber() {
		fixture.setPhoneNumber("123-3456-6675-575");
		Assert.assertEquals("(123) 345-6667 ext:5575", fixture.getPhoneNumber());
		Assert.assertEquals("12334566675575", fixture.getPhoneNumberRaw());
	}

	@Test
	public void testFaxNumber() {
		fixture.setFaxNumber("123-3456-6675-575");
		Assert.assertEquals("(123) 345-6667 ext:5575", fixture.getFaxNumber());
		Assert.assertEquals("12334566675575", fixture.getFaxNumberRaw());
	}
}