/* TabboxAccordion.java

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Sep 6, 2007 8:04:12 PM , Created by robbiecheng
}}IS_NOTE

Copyright (C) 2007 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
	This program is distributed under GPL Version 2.0 in the hope that
	it will be useful, but WITHOUT ANY WARRANTY.
}}IS_RIGHT
*/
package org.zkoss.zul.render;

import java.io.IOException;
import java.io.Writer;

import org.zkoss.zk.fn.ZkFns;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.ComponentRenderer;
import org.zkoss.zul.Tabbox;

/**
 * {@link Tabbox}'s accordion mold.
 * 
 * @author robbiecheng
 * 
 * @since 3.0.0
 */

public class TabboxAccordion implements ComponentRenderer {
	
	/**
<c:set var="self" value="${requestScope.arg.self}"/>
<table id="${self.uuid}"${self.outerAttrs}${self.innerAttrs} z.accd="true" border="0" cellpadding="0" cellspacing="0">
${z:redraw(self.tabpanels, null)}
</table>
	 */

	public void render(Component comp, Writer out) throws IOException {
		final WriterHelper wh = new WriterHelper(out);
		final Tabbox self = (Tabbox) comp;		
		wh.write("<table id=\"" + self.getUuid() + "\"" + self.getOuterAttrs() + self.getInnerAttrs() + " z.accd=\"true\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">");	
		ZkFns.redraw(self.getTabpanels(), null);
		wh.write("</table>");
	}

}
