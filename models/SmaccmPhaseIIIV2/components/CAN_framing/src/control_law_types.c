/* This file has been autogenerated by Ivory
 * Compiler version  0.1.0.3
 */
#include "control_law_types.h"

void control_law_get_le(const uint8_t *n_var0, uint32_t n_var1, struct control_law *n_var2)
{
    arming_mode_t_get_le(n_var0, n_var1, &n_var2->arming_mode);
    control_modes_get_le(n_var0, (uint32_t) (n_var1 + (uint32_t) 1U), &n_var2->control_modes);
}

void control_law_get_be(const uint8_t *n_var0, uint32_t n_var1, struct control_law *n_var2)
{
    arming_mode_t_get_be(n_var0, n_var1, &n_var2->arming_mode);
    control_modes_get_be(n_var0, (uint32_t) (n_var1 + (uint32_t) 1U), &n_var2->control_modes);
}

void control_law_set_le(uint8_t *n_var0, uint32_t n_var1, const struct control_law *n_var2)
{
    arming_mode_t_set_le(n_var0, n_var1, &n_var2->arming_mode);
    control_modes_set_le(n_var0, (uint32_t) (n_var1 + (uint32_t) 1U), &n_var2->control_modes);
}

void control_law_set_be(uint8_t *n_var0, uint32_t n_var1, const struct control_law *n_var2)
{
    arming_mode_t_set_be(n_var0, n_var1, &n_var2->arming_mode);
    control_modes_set_be(n_var0, (uint32_t) (n_var1 + (uint32_t) 1U), &n_var2->control_modes);
}