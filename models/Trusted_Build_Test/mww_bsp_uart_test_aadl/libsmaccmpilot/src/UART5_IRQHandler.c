/* This file has been autogenerated by Ivory
 * Compiler version  0.1.0.2
 */
#include "UART5_IRQHandler.h"

void UART5_IRQHandler(void)
{
    /* reg set nvic_icer1: setBit nvic_icer_clrena.[21] */
    ivory_hw_io_write_u32((uint32_t) 3758154116U, (uint32_t) ((uint32_t) 1U << (uint32_t) 21U));
}