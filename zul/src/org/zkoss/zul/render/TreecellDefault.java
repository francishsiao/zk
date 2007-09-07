/* TreecellDefault.java

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Sep 7, 2007 8:17:41 AM , Created by robbiecheng
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
import java.util.Iterator;

import org.zkoss.lang.Strings;
import org.zkoss.zk.fn.ZkFns;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.ComponentRenderer;
import org.zkoss.zul.Treecell;

/**
 * {@link Treecell}'s default mold.
 * 
 * @author robbiecheng
 * 
 * @since 3.0.0
 */
public class TreecellDefault implements ComponentRenderer{
/**
<c:set var="self" value="${requestScope.arg.self}"/>
<td id="${self.uuid}"${self.outerAttrs}${self.innerAttrs}>${self.columnHtmlPrefix}${self.imgTag}
<c:out value="${self.label}" maxlength="${self.maxlength}"/>
<c:forEach var="child" items="${self.children}">
${z:redraw(child, null)}
</c:forEach>
${self.columnHtmlPostfix}
</td>

 */
	public void render(Component comp, Writer out) throws IOException {
		final WriterHelper wh = new WriterHelper(out);
		final Treecell self = (Treecell) comp;
		
		wh.write("<td id=\"" + self.getUuid() + "\"" + self.getOuterAttrs() + self.getInnerAttrs() +">");
		
		if(!Strings.isBlank(self.getColumnHtmlPrefix()))
			wh.write(self.getColumnHtmlPrefix());
		if (!Strings.isBlank(self.getImgTag()))
			wh.write(self.getImgTag());
		if (!Strings.isBlank(self.getLabel()))
			RenderFns.getOut(out).setValue(self.getLabel()).render();
		RenderFns.getOut(out).setMaxlength(self.getMaxlength()).render();
		
		for (Iterator it = self.getChildren().iterator(); it.hasNext();) {
			final Component child = (Component) it.next();
			ZkFns.redraw(child, null);
		}	
		if(!Strings.isBlank(self.getColumnHtmlPostfix()))
			wh.write(self.getColumnHtmlPostfix());
		
		wh.write("</td>");

	}
}
