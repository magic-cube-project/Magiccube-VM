/*
 * Description: 
 *     History: lemon@mofang.com, 2018/09/28, create
 */

# ifndef _AW_STATE_H_
# define _AW_STATE_H_

int init_state(void);

int state_subscribe(nw_ses *ses, const char *market);
int state_unsubscribe(nw_ses *ses);
int state_send_last(nw_ses *ses, const char *market);

# endif

