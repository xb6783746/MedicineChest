/**
 * Created by Влад on 15.04.2017.
 */

function handleLoginRequest(args, name) {
    if(args.validationFailed) {
        //PF('dlg2').jq.effect("shake", {times:5}, 100);
    }
    else {
        PF(name).hide();
    }
}