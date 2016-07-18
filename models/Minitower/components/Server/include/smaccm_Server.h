#ifndef __SMACCM_Server_types__H
#define __SMACCM_Server_types__H

#include "smaccm_top_i_types.h"

/**************************************************************************
  Copyright (c) 2013, 2014, 2015 Rockwell Collins and the University of Minnesota.
  Developed with the sponsorship of the Defense Advanced Research Projects Agency (DARPA).

  Permission is hereby granted, free of charge, to any person obtaining a copy of this data,
  including any software or models in source or binary form, as well as any drawings, specifications, 
  and documentation (collectively "the Data"), to deal in the Data without restriction, including 
  without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, 
  and/or sell copies of the Data, and to permit persons to whom the Data is furnished to do so, 
  subject to the following conditions: 

  The above copyright notice and this permission notice shall be included in all copies or
  substantial portions of the Data.

  THE DATA IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT 
  LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. 
  IN NO EVENT SHALL THE AUTHORS, SPONSORS, DEVELOPERS, CONTRIBUTORS, OR COPYRIGHT HOLDERS BE LIABLE 
  FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, 
  ARISING FROM, OUT OF OR IN CONNECTION WITH THE DATA OR THE USE OR OTHER DEALINGS IN THE DATA. 

 **************************************************************************/


/**************************************************************************

   File: /home/ajgacek/minitower/june/apps/smaccmpilot/components/Server/include/smaccm_Server.h
   Created on: 2016/07/18 14:04:53
   using Dulcimer AADL system build tool suite 

   ***AUTOGENERATED CODE: DO NOT MODIFY***

  This header section contains the AADL gluecode interfaces used by the client
  for the thread implementations.

 **************************************************************************/

	// These are functions that are expected to be provided by the user.
	void component_entry(const int64_t * periodic_dispatcher); 

	void component_init(const int64_t * Server_initializer); 



	// These are functions that are provided by the AADL middleware for 
	// communication with other threads
	bool Server_write_self2vm_reboot(const bool * self2vm_reboot); 
	bool Server_write_self2encrypt(const SMACCM_DATA__GIDL self2encrypt); 
	bool Server_write_self2framing(const SMACCM_DATA__GIDL self2framing); 

	bool Server_read_periodic_dispatcher(int64_t * periodic_dispatcher); 
	bool Server_read_Server_initializer(int64_t * Server_initializer); 
	bool Server_read_vm2self(SMACCM_DATA__Camera_Bounding_Box_i * vm2self); 
	bool Server_read_decrypt2self(SMACCM_DATA__GIDL decrypt2self); 
	bool Server_read_framing2self(SMACCM_DATA__GIDL framing2self); 

	
/* endif for: #ifndef __SMACCM_Server_types__H */
#endif

/**************************************************************************
  End of autogenerated file: /home/ajgacek/minitower/june/apps/smaccmpilot/components/Server/include/smaccm_Server.h
 **************************************************************************/

