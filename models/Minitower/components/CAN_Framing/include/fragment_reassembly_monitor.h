/* This file has been autogenerated by Ivory
 * Compiler version  0.1.0.4
 */
#ifndef __FRAGMENT_REASSEMBLY_MONITOR_H__
#define __FRAGMENT_REASSEMBLY_MONITOR_H__
#ifdef __cplusplus
extern "C" {
#endif
#include "ivory.h"
#include "smaccm_can_module.h"
#include "ivory_serialize.h"
#include "canDriverTypes.h"
#include "output_tb_CAN_Framing_write_self2server_monitor.h"
extern uint8_t reassembly_next_idx_0x100;
extern uint8_t reassembly_buf_0x100[80U];
void callback_receive_msg(const struct can_message *n_var0);

#ifdef __cplusplus
}
#endif
#endif /* __FRAGMENT_REASSEMBLY_MONITOR_H__ */
