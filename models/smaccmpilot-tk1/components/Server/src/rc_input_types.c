/* This file has been autogenerated by Ivory
 * Compiler version  0.1.0.5
 */
#include "rc_input_types.h"

void rc_input_get_le(const uint8_t *n_var0, uint32_t n_var1, struct rc_input *n_var2)
{
    ibool_get_le(n_var0, n_var1, &n_var2->valid);
    ivory_serialize_unpack_uint16_le(n_var0, (uint32_t) (n_var1 + (uint32_t) 1U), &n_var2->roll);
    ivory_serialize_unpack_uint16_le(n_var0, (uint32_t) (n_var1 + (uint32_t) 3U), &n_var2->pitch);
    ivory_serialize_unpack_uint16_le(n_var0, (uint32_t) (n_var1 + (uint32_t) 5U), &n_var2->throttle);
    ivory_serialize_unpack_uint16_le(n_var0, (uint32_t) (n_var1 + (uint32_t) 7U), &n_var2->yaw);
    ivory_serialize_unpack_uint16_le(n_var0, (uint32_t) (n_var1 + (uint32_t) 9U), &n_var2->switch1);
    ivory_serialize_unpack_uint16_le(n_var0, (uint32_t) (n_var1 + (uint32_t) 11U), &n_var2->switch2);
    time_micros_t_get_le(n_var0, (uint32_t) (n_var1 + (uint32_t) 13U), &n_var2->time);
}

void rc_input_get_be(const uint8_t *n_var0, uint32_t n_var1, struct rc_input *n_var2)
{
    ibool_get_be(n_var0, n_var1, &n_var2->valid);
    ivory_serialize_unpack_uint16_be(n_var0, (uint32_t) (n_var1 + (uint32_t) 1U), &n_var2->roll);
    ivory_serialize_unpack_uint16_be(n_var0, (uint32_t) (n_var1 + (uint32_t) 3U), &n_var2->pitch);
    ivory_serialize_unpack_uint16_be(n_var0, (uint32_t) (n_var1 + (uint32_t) 5U), &n_var2->throttle);
    ivory_serialize_unpack_uint16_be(n_var0, (uint32_t) (n_var1 + (uint32_t) 7U), &n_var2->yaw);
    ivory_serialize_unpack_uint16_be(n_var0, (uint32_t) (n_var1 + (uint32_t) 9U), &n_var2->switch1);
    ivory_serialize_unpack_uint16_be(n_var0, (uint32_t) (n_var1 + (uint32_t) 11U), &n_var2->switch2);
    time_micros_t_get_be(n_var0, (uint32_t) (n_var1 + (uint32_t) 13U), &n_var2->time);
}

void rc_input_set_le(uint8_t *n_var0, uint32_t n_var1, const struct rc_input *n_var2)
{
    ibool_set_le(n_var0, n_var1, &n_var2->valid);
    ivory_serialize_pack_uint16_le(n_var0, (uint32_t) (n_var1 + (uint32_t) 1U), &n_var2->roll);
    ivory_serialize_pack_uint16_le(n_var0, (uint32_t) (n_var1 + (uint32_t) 3U), &n_var2->pitch);
    ivory_serialize_pack_uint16_le(n_var0, (uint32_t) (n_var1 + (uint32_t) 5U), &n_var2->throttle);
    ivory_serialize_pack_uint16_le(n_var0, (uint32_t) (n_var1 + (uint32_t) 7U), &n_var2->yaw);
    ivory_serialize_pack_uint16_le(n_var0, (uint32_t) (n_var1 + (uint32_t) 9U), &n_var2->switch1);
    ivory_serialize_pack_uint16_le(n_var0, (uint32_t) (n_var1 + (uint32_t) 11U), &n_var2->switch2);
    time_micros_t_set_le(n_var0, (uint32_t) (n_var1 + (uint32_t) 13U), &n_var2->time);
}

void rc_input_set_be(uint8_t *n_var0, uint32_t n_var1, const struct rc_input *n_var2)
{
    ibool_set_be(n_var0, n_var1, &n_var2->valid);
    ivory_serialize_pack_uint16_be(n_var0, (uint32_t) (n_var1 + (uint32_t) 1U), &n_var2->roll);
    ivory_serialize_pack_uint16_be(n_var0, (uint32_t) (n_var1 + (uint32_t) 3U), &n_var2->pitch);
    ivory_serialize_pack_uint16_be(n_var0, (uint32_t) (n_var1 + (uint32_t) 5U), &n_var2->throttle);
    ivory_serialize_pack_uint16_be(n_var0, (uint32_t) (n_var1 + (uint32_t) 7U), &n_var2->yaw);
    ivory_serialize_pack_uint16_be(n_var0, (uint32_t) (n_var1 + (uint32_t) 9U), &n_var2->switch1);
    ivory_serialize_pack_uint16_be(n_var0, (uint32_t) (n_var1 + (uint32_t) 11U), &n_var2->switch2);
    time_micros_t_set_be(n_var0, (uint32_t) (n_var1 + (uint32_t) 13U), &n_var2->time);
}
