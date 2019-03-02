/* This file has been autogenerated by Ivory
 * Compiler version  0.1.0.0
 */
#ifndef __MAVLINK_DATA64_MSG_H__
#define __MAVLINK_DATA64_MSG_H__
#ifdef __cplusplus
extern "C" {
#endif
#include "ivory.h"
#include "mavlinkSendModule.h"
#include "mavlink_pack_ivory.h"
struct data64_msg {
    uint8_t data64_type;
    uint8_t len;
    uint8_t data64[64U];
} __attribute__((__packed__));
void mavlink_data64_msg_send(const struct data64_msg* n_var0, uint8_t* n_var1,
                             uint8_t n_var2[80U]);
void mavlink_data64_unpack(struct data64_msg* n_var0, const uint8_t* n_var1);

#ifdef __cplusplus
}
#endif
#endif /* __MAVLINK_DATA64_MSG_H__ */