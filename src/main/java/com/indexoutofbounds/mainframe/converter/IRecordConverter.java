/*
 * Copyright (c) 2005 - 2007 Travis B. Meisenheimer
 * All rights reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */

package com.indexoutofbounds.mainframe.converter;

import com.indexoutofbounds.mainframe.exception.MainFrameConversionException;
import com.indexoutofbounds.mainframe.file.Record;
import com.indexoutofbounds.mainframe.file.layout.FileRecordLayout;

/**
 * <p>Interface which defines what a RecordConverter must be able to do.  This is
 * the best way to translate a mainframe file.</p>
 * 
 * <p>A hex viewer can be used to view the raw binary data.  FreeBSD's <i>hexdump</i> or
 * the Solaris command <i>od -X -A n  [file]</i> can be used.</p>
 * 
 * @author <a href="mailto:travis@indexoutofbounds.com">Travis Meisenheimer</a>
 * @version $Id$
 */
public interface IRecordConverter {
	
	/**
	 * Gets the next record from the file.  Returns the converted Record
	 * or null if we've hit the EOF.  It is up to the caller to handle the
	 * MainFrameConversionException (which are generally terminal).
	 * 
	 * @return the newly converted Record or NULL if we hit EOF
	 * @throws MainFrameConversionException
	 */
	public Record getNextRecord() throws MainFrameConversionException;
	
	/**
	 * 
	 * @return the file record's layout
	 */	
	public FileRecordLayout getFileRecordLayout();
	
	/**
	 * 
	 * @return row count
	 */	
	public int getRowCount();
}
