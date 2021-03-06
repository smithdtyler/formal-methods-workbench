#ifndef __SMACCM_test16_shared_data_impl_Instance_types__H
#define __SMACCM_test16_shared_data_impl_Instance_types__H

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

   File: C:\Users\jdbackes\git\smaccm\models\Trusted_Build_Test\test16_shared_data\include\smaccm_test16_shared_data_impl_types.h
   Created on: 2015/12/01 15:14:06
   using Dulcimer AADL system build tool suite 

   ***AUTOGENERATED CODE: DO NOT MODIFY***

  This file contains the datatypes used for communications between 
  AADL components as defined in the system implementation test16_shared_data_impl_Instance.

 **************************************************************************/

#include <stdbool.h>
#include <stddef.h>
#include <stdint.h>
// Headers for externally declared types.

// AADL-defined types.
typedef 
      struct smaccm_receiver_periodic_dispatcher_struct { 
         uint32_t unused  ; 
      } smaccm_receiver_periodic_dispatcher_struct ; 

typedef uint8_t test16__a_array_impl [255]; 

typedef 
      struct test16__a_struct_wrapper_impl { 
         test16__a_array_impl f  ; 
      } test16__a_struct_wrapper_impl ; 

typedef 
      struct smaccm_sender_periodic_dispatcher_struct { 
         uint32_t unused  ; 
      } smaccm_sender_periodic_dispatcher_struct ; 

typedef 
      struct smaccm_test16__a_array_impl_container { 
         test16__a_array_impl f  ; 
      } smaccm_test16__a_array_impl_container ; 

/* endif for: #ifndef __SMACCM_test16_shared_data_impl_Instance_types__H */
#endif

/**************************************************************************
  End of autogenerated file: smaccm_test16_shared_data_impl_types.h
 **************************************************************************/

