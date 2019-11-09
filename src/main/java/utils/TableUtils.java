/**
 * Util for calendar table handling
 * @author FalcoConstantine
 */
package utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TableUtils {
	
	public static List<WebElement> getTableBodyRowsList(WebElement table) {
		return table.findElement(By.tagName("tbody")).findElements(By.tagName("tr"));
	}

	public static WebElement getTableBodyRowByText(WebElement table, String text) {
		for (WebElement row : getTableBodyRowsList(table)) {
			for (WebElement cols : row.findElements(By.tagName("td"))) {
				if (cols.getText().equals(text)) {
					cols.click();
					return row;
				}
			}
		}
		return null;
	}
	
	public static WebElement getRowElementByIndex(WebElement row, int index) {
		return row.findElements(By.tagName("td")).get(index);
	}

}
