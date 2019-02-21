/* This file has been autogenerated by Ivory
 * Compiler version  0.1.0.0
 */
#ifndef __MAVLINK_ATTITUDE_MSG_H__
#define __MAVLINK_ATTITUDE_MSG_H__
#ifdef __cplusplus
extern "C" {
#endif
#include "ivory.h"
#include "mavlinkSendModule.h"
#include "mavlink_pack_ivory.h"
struct attitude_msg {
    uint32_t time_boot_ms;
    float roll;
    float pitch;
    float yaw;
    float rollspeed;
    float pitchspeed;
    float yawspeed;
} __attribute__((__packed__));
void mavlink_attitude_msg_send(const struct attitude_msg* n_var0,
                               uint8_t* n_var1, uint8_t n_var2[80U]);
void mavlink_attitude_unpack(struct attitude_msg* n_var0, const
                             uint8_t* n_var1);

#ifdef __cplusplus
}
#endif
#endif /* __MAVLINK_ATTITUDE_MSG_H__ */