/* This file has been autogenerated by Ivory
 * Compiler version  0.1.0.0
 */
#include "mavlink_heartbeat_msg.h"

void mavlink_heartbeat_msg_send(const struct heartbeat_msg* n_var0,
                                uint8_t* n_var1, uint8_t n_var2[80U])
{
    uint8_t n_local0[9U] = {};
    uint8_t* n_ref1 = n_local0;
    uint32_t n_deref2 = n_var0->custom_mode;
    
    mavlink_pack_uint32_t((uint8_t*) n_ref1, 0U, n_deref2);
    
    uint8_t n_deref3 = n_var0->mavtype;
    
    mavlink_pack_uint8_t((uint8_t*) n_ref1, 4U, n_deref3);
    
    uint8_t n_deref4 = n_var0->autopilot;
    
    mavlink_pack_uint8_t((uint8_t*) n_ref1, 5U, n_deref4);
    
    uint8_t n_deref5 = n_var0->base_mode;
    
    mavlink_pack_uint8_t((uint8_t*) n_ref1, 6U, n_deref5);
    
    uint8_t n_deref6 = n_var0->system_status;
    
    mavlink_pack_uint8_t((uint8_t*) n_ref1, 7U, n_deref6);
    
    uint8_t n_deref7 = n_var0->mavlink_version;
    
    mavlink_pack_uint8_t((uint8_t*) n_ref1, 8U, n_deref7);
    for (int32_t n_ix8 = 0; n_ix8 <= 8; n_ix8++) {
        ASSERTS(n_ix8 > 0 && 2147483647 - n_ix8 >= 6 || n_ix8 <= 0);
        if (n_ix8 + 6 >= 80) { } else {
            uint8_t n_deref9 = n_ref1[n_ix8];
            
            ASSERTS(n_ix8 > 0 && 2147483641 >= n_ix8 || n_ix8 <= 0);
            ASSERTS(0 <= 6 + n_ix8 && 6 + n_ix8 < 80);
            *&n_var2[(6 + n_ix8) % 80] = n_deref9;
        }
    }
    mavlinkSendWithWriter(0U, 50U, 9U, n_var1, n_var2);
    for (int32_t n_ix10 = 0; n_ix10 <= 62; n_ix10++) {
        ASSERTS(n_ix10 > 0 && 2147483647 - n_ix10 >= 17 || n_ix10 <= 0);
        ASSERTS(0 <= n_ix10 + 17 && n_ix10 + 17 < 80);
        *&n_var2[(n_ix10 + 17) % 80] = 0U;
    }
    return;
}

void mavlink_heartbeat_unpack(struct heartbeat_msg* n_var0, const
                              uint8_t* n_var1)
{
    uint32_t n_r0 = mavlink_unpack_uint32_t(n_var1, 0U);
    
    *&n_var0->custom_mode = n_r0;
    
    uint8_t n_r1 = mavlink_unpack_uint8_t(n_var1, 4U);
    
    *&n_var0->mavtype = n_r1;
    
    uint8_t n_r2 = mavlink_unpack_uint8_t(n_var1, 5U);
    
    *&n_var0->autopilot = n_r2;
    
    uint8_t n_r3 = mavlink_unpack_uint8_t(n_var1, 6U);
    
    *&n_var0->base_mode = n_r3;
    
    uint8_t n_r4 = mavlink_unpack_uint8_t(n_var1, 7U);
    
    *&n_var0->system_status = n_r4;
    
    uint8_t n_r5 = mavlink_unpack_uint8_t(n_var1, 8U);
    
    *&n_var0->mavlink_version = n_r5;
}