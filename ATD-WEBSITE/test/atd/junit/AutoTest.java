/*******************************************************************************
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *******************************************************************************/
package atd.junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import atd.domein.Auto;
public class AutoTest {

	@Test
	public void AutoTest() {
		Auto Testauto = new Auto(0, "12-ab-1", "volvo", "type");
		
		int id = Testauto.getId();
		assertNotNull(id);
		assertEquals(id, Testauto.getId());
		
		String kenteken = Testauto.getKenteken();
		assertNotNull(kenteken);
		assertEquals(kenteken, Testauto.getKenteken());
		
		String merk = Testauto.getMerk();
		Testauto.setMerk(merk);
		assertNotNull(merk);
		assertEquals(merk, Testauto.getMerk());
		
		String type = Testauto.getType();
		Testauto.setType(type);
		assertNotNull(type);
		assertEquals(type, Testauto.getType());
	}
}