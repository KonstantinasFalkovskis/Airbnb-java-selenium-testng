/**
 * Util for calendar table handling
 * @author FalcoConstantine
 */
package utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CalendarUtils {
	
	public List<WebElement> getTableBodyRowsList(WebElement table) {
		return table.findElement(By.tagName("tbody")).findElements(By.tagName("tr"));
	}

	public WebElement getTableBodyRowByText(WebElement table, String date) {
		for (WebElement row : getTableBodyRowsList(table)) {
			for (WebElement cols : row.findElements(By.tagName("td"))) {
				if (cols.getText().equals(date)) {
					cols.click();
					//return row;
				}
			}
		}
		return null;
	}
	
	public WebElement getRowElementByIndex(WebElement row, int index) {
		return row.findElements(By.tagName("td")).get(index);
	}

}
