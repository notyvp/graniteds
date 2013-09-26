/*
  GRANITE DATA SERVICES
  Copyright (C) 2011 GRANITE DATA SERVICES S.A.S.

  This file is part of Granite Data Services.

  Granite Data Services is free software; you can redistribute it and/or modify
  it under the terms of the GNU Library General Public License as published by
  the Free Software Foundation; either version 2 of the License, or (at your
  option) any later version.

  Granite Data Services is distributed in the hope that it will be useful, but
  WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
  FITNESS FOR A PARTICULAR PURPOSE. See the GNU Library General Public License
  for more details.

  You should have received a copy of the GNU Library General Public License
  along with this library; if not, see <http://www.gnu.org/licenses/>.
*/

package org.granite.generator;

import java.io.IOException;
import java.io.Writer;
import java.net.URI;
import java.util.Map;

import org.granite.generator.exception.TemplateCompilationException;
import org.granite.generator.exception.TemplateExecutionException;
import org.granite.generator.exception.TemplateParsingException;

/**
 * @author Franck WOLFF
 */
public interface Template {

    public URI getUri();
    
    public boolean isBase();

    public String getMarkup();

    public String getSource();

    public void compile() throws IOException, TemplateParsingException, TemplateCompilationException;

    public void execute(Map<String, Object> bindings, Writer out)
    	throws IOException, TemplateParsingException, TemplateCompilationException, TemplateExecutionException;
}
