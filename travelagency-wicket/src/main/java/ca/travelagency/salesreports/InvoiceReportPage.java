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
package ca.travelagency.salesreports;

import java.util.HashMap;
import java.util.Map;

import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;

import ca.travelagency.BasePrintPage;

@AuthorizeInstantiation({"AGENT"})
public class InvoiceReportPage extends BasePrintPage {
	private static final long serialVersionUID = 1L;

	static final String REPORT_TITLE = "Invoices Report";

	public InvoiceReportPage(String template, InvoiceSalesModel invoiceSalesModel) {
		super(template, invoiceSalesModel);
	}

	@Override
	protected Map<String, Object> getObjectMap() {
		InvoiceSalesModel invoiceSalesModel = (InvoiceSalesModel) getDefaultModel();

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("reportsSearch", invoiceSalesModel.getReportsSearch());
		map.put("invoiceSales", invoiceSalesModel.getObject());
		return map;
	}

	@Override
	protected String getPageTitle() {
		return REPORT_TITLE;
	}
}
