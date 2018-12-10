/* This file has been autogenerated by Ivory
 * Compiler version  0.1.0.5
 */
#include "pid_state_types.h"

void pid_state_get_le(const uint8_t *n_var0, uint32_t n_var1, struct pid_state *n_var2)
{
    ivory_serialize_unpack_float_le(n_var0, n_var1, &n_var2->i_state);
    ivory_serialize_unpack_float_le(n_var0, (uint32_t) (n_var1 + (uint32_t) 4U), &n_var2->d_term);
    ivory_serialize_unpack_float_le(n_var0, (uint32_t) (n_var1 + (uint32_t) 8U), &n_var2->dd_term);
    ivory_serialize_unpack_float_le(n_var0, (uint32_t) (n_var1 + (uint32_t) 12U), &n_var2->p_term);
    ivory_serialize_unpack_float_le(n_var0, (uint32_t) (n_var1 + (uint32_t) 16U), &n_var2->i_term);
    ivory_serialize_unpack_float_le(n_var0, (uint32_t) (n_var1 + (uint32_t) 20U), &n_var2->angle_err);
    ivory_serialize_unpack_float_le(n_var0, (uint32_t) (n_var1 + (uint32_t) 24U), &n_var2->rate_err);
}

void pid_state_get_be(const uint8_t *n_var0, uint32_t n_var1, struct pid_state *n_var2)
{
    ivory_serialize_unpack_float_be(n_var0, n_var1, &n_var2->i_state);
    ivory_serialize_unpack_float_be(n_var0, (uint32_t) (n_var1 + (uint32_t) 4U), &n_var2->d_term);
    ivory_serialize_unpack_float_be(n_var0, (uint32_t) (n_var1 + (uint32_t) 8U), &n_var2->dd_term);
    ivory_serialize_unpack_float_be(n_var0, (uint32_t) (n_var1 + (uint32_t) 12U), &n_var2->p_term);
    ivory_serialize_unpack_float_be(n_var0, (uint32_t) (n_var1 + (uint32_t) 16U), &n_var2->i_term);
    ivory_serialize_unpack_float_be(n_var0, (uint32_t) (n_var1 + (uint32_t) 20U), &n_var2->angle_err);
    ivory_serialize_unpack_float_be(n_var0, (uint32_t) (n_var1 + (uint32_t) 24U), &n_var2->rate_err);
}

void pid_state_set_le(uint8_t *n_var0, uint32_t n_var1, const struct pid_state *n_var2)
{
    ivory_serialize_pack_float_le(n_var0, n_var1, &n_var2->i_state);
    ivory_serialize_pack_float_le(n_var0, (uint32_t) (n_var1 + (uint32_t) 4U), &n_var2->d_term);
    ivory_serialize_pack_float_le(n_var0, (uint32_t) (n_var1 + (uint32_t) 8U), &n_var2->dd_term);
    ivory_serialize_pack_float_le(n_var0, (uint32_t) (n_var1 + (uint32_t) 12U), &n_var2->p_term);
    ivory_serialize_pack_float_le(n_var0, (uint32_t) (n_var1 + (uint32_t) 16U), &n_var2->i_term);
    ivory_serialize_pack_float_le(n_var0, (uint32_t) (n_var1 + (uint32_t) 20U), &n_var2->angle_err);
    ivory_serialize_pack_float_le(n_var0, (uint32_t) (n_var1 + (uint32_t) 24U), &n_var2->rate_err);
}

void pid_state_set_be(uint8_t *n_var0, uint32_t n_var1, const struct pid_state *n_var2)
{
    ivory_serialize_pack_float_be(n_var0, n_var1, &n_var2->i_state);
    ivory_serialize_pack_float_be(n_var0, (uint32_t) (n_var1 + (uint32_t) 4U), &n_var2->d_term);
    ivory_serialize_pack_float_be(n_var0, (uint32_t) (n_var1 + (uint32_t) 8U), &n_var2->dd_term);
    ivory_serialize_pack_float_be(n_var0, (uint32_t) (n_var1 + (uint32_t) 12U), &n_var2->p_term);
    ivory_serialize_pack_float_be(n_var0, (uint32_t) (n_var1 + (uint32_t) 16U), &n_var2->i_term);
    ivory_serialize_pack_float_be(n_var0, (uint32_t) (n_var1 + (uint32_t) 20U), &n_var2->angle_err);
    ivory_serialize_pack_float_be(n_var0, (uint32_t) (n_var1 + (uint32_t) 24U), &n_var2->rate_err);
}