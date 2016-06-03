/* This file has been autogenerated by Ivory
 * Compiler version  0.1.0.3
 */
#include "UART_out.h"

static void component_entry_aux(void);

static void component_entry_aux_2(void);

void component_entry(void)
{
    component_entry_aux();
    component_entry_aux_2();
    
    int64_t n_local0 = (int64_t) 0;
    int64_t *n_ref1 = &n_local0;
    
    return;
}

void component_init(void)
{
    int64_t n_local0 = (int64_t) 0;
    int64_t *n_ref1 = &n_local0;
    
    callback_configureStaticKey(n_ref1);
}

void component_entry_aux(void)
{
    uint8_t n_local0[80U] = {};
    uint8_t *n_ref1 = n_local0;
    bool n_r2 = UART_out_read_get_gidl(n_ref1);
    //bool n_r2 = Server_UART_out_get_pt_data(n_ref1);
    
    if (n_r2) {
        callback_input_Server_UART_out_get_pt_data_handler(n_ref1);
    }
    return;
}

void component_entry_aux_2(void)
{
    bool n_local0 = false;
    bool *n_ref1 = &n_local0;
    bool n_r2 = UART_out_read_recv_response(n_ref1);
    //bool n_r2 = UART_hw_UART_out_get_bool(n_ref1);
    
    if (n_r2) {
        callback_input_UART_hw_UART_out_get_bool_handler(n_ref1);
    }
    return;
}
