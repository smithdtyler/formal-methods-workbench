#ifndef __SMACCM_top_i_Instance_types__H
#define __SMACCM_top_i_Instance_types__H

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

   File: /home/ajgacek/minitower/june/apps/smaccmpilot/include/smaccm_top_i_types.h
   Created on: 2016/07/18 14:04:53
   using Dulcimer AADL system build tool suite 

   ***AUTOGENERATED CODE: DO NOT MODIFY***

  This file contains the datatypes used for communications between 
  AADL components as defined in the system implementation top_i_Instance.

 **************************************************************************/

#include <stdbool.h>
#include <stddef.h>
#include <stdint.h>
// Headers for externally declared types.

// AADL-defined types.
typedef uint8_t SMACCM_DATA__CAN_Buffer [8]; 

typedef 
      struct smaccm_CAN_Framing_can2self_status_struct { 
         uint32_t unused  ; 
      } smaccm_CAN_Framing_can2self_status_struct ; 

typedef 
      struct smaccm_Encrypt_uart2self_struct { 
         uint32_t unused  ; 
      } smaccm_Encrypt_uart2self_struct ; 

typedef 
      struct smaccm_CAN_Driver_framing2self_struct { 
         uint32_t unused  ; 
      } smaccm_CAN_Driver_framing2self_struct ; 

typedef 
      struct SMACCM_DATA__Camera_Bounding_Box_i { 
         uint16_t left  ; 
         uint16_t right  ; 
         uint16_t top  ; 
         uint16_t bottom  ; 
      } SMACCM_DATA__Camera_Bounding_Box_i ; 

typedef 
      struct smaccm_CAN_Framing_CAN_Framing_initializer_struct { 
         uint32_t unused  ; 
      } smaccm_CAN_Framing_CAN_Framing_initializer_struct ; 

typedef 
      struct smaccm_Decrypt_Decrypt_initializer_struct { 
         uint32_t unused  ; 
      } smaccm_Decrypt_Decrypt_initializer_struct ; 

typedef 
      struct smaccm_Encrypt_server2self_struct { 
         uint32_t unused  ; 
      } smaccm_Encrypt_server2self_struct ; 

typedef 
      struct smaccm_Server_decrypt2self_struct { 
         uint32_t unused  ; 
      } smaccm_Server_decrypt2self_struct ; 

typedef 
      struct smaccm_CAN_Framing_can2self_frame_struct { 
         uint32_t unused  ; 
      } smaccm_CAN_Framing_can2self_frame_struct ; 

typedef 
      struct smaccm_CAN_Framing_server2self_struct { 
         uint32_t unused  ; 
      } smaccm_CAN_Framing_server2self_struct ; 

typedef uint8_t SMACCM_DATA__UART_Buffer [255]; 

typedef 
      struct SMACCM_DATA__UART_Packet_i { 
         SMACCM_DATA__UART_Buffer buf  ; 
         int32_t buf_len  ; 
      } SMACCM_DATA__UART_Packet_i ; 

typedef uint8_t SMACCM_DATA__GIDL [80]; 

typedef 
      struct smaccm_CAN_Framing_periodic_dispatcher_struct { 
         uint32_t unused  ; 
      } smaccm_CAN_Framing_periodic_dispatcher_struct ; 

typedef 
      struct smaccm_Encrypt_periodic_dispatcher_struct { 
         uint32_t unused  ; 
      } smaccm_Encrypt_periodic_dispatcher_struct ; 

typedef 
      struct smaccm_Encrypt_Encrypt_initializer_struct { 
         uint32_t unused  ; 
      } smaccm_Encrypt_Encrypt_initializer_struct ; 

typedef 
      struct smaccm_Server_framing2self_struct { 
         uint32_t unused  ; 
      } smaccm_Server_framing2self_struct ; 

typedef 
      struct smaccm_Decrypt_periodic_dispatcher_struct { 
         uint32_t unused  ; 
      } smaccm_Decrypt_periodic_dispatcher_struct ; 

typedef 
      struct smaccm_Server_periodic_dispatcher_struct { 
         uint32_t unused  ; 
      } smaccm_Server_periodic_dispatcher_struct ; 

typedef 
      struct smaccm_Server_Server_initializer_struct { 
         uint32_t unused  ; 
      } smaccm_Server_Server_initializer_struct ; 

typedef 
      struct smaccm_UART_Driver_encrypt2self_struct { 
         uint32_t unused  ; 
      } smaccm_UART_Driver_encrypt2self_struct ; 

typedef 
      struct smaccm_Decrypt_uart2self_struct { 
         uint32_t unused  ; 
      } smaccm_Decrypt_uart2self_struct ; 

typedef 
      struct SMACCM_DATA__CAN_Frame_i { 
         uint32_t id  ; 
         SMACCM_DATA__CAN_Buffer buf  ; 
         uint8_t buf_len  ; 
      } SMACCM_DATA__CAN_Frame_i ; 

typedef 
      struct smaccm_SMACCM_DATA__CAN_Buffer_container { 
         SMACCM_DATA__CAN_Buffer f  ; 
      } smaccm_SMACCM_DATA__CAN_Buffer_container ; 

typedef 
      struct smaccm_SMACCM_DATA__UART_Buffer_container { 
         SMACCM_DATA__UART_Buffer f  ; 
      } smaccm_SMACCM_DATA__UART_Buffer_container ; 

typedef 
      struct smaccm_SMACCM_DATA__GIDL_container { 
         SMACCM_DATA__GIDL f  ; 
      } smaccm_SMACCM_DATA__GIDL_container ; 

/* endif for: #ifndef __SMACCM_top_i_Instance_types__H */
#endif

/**************************************************************************
  End of autogenerated file: smaccm_top_i_types.h
 **************************************************************************/

