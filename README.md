Nachos
------
Android monitoring client for a XMPP server. This app checks a configurable XMPP server at a regular
interval and reports the health check.

Docker
------
Start [ejabberd](https://www.ejabberd.im/):

    docker run --rm \
        --name "ejabberd" \
        -p 5222:5222 \
        -p 5269:5269 \
        -p 52443:5280 \
        -e "XMPP_DOMAIN=ejabberd" \
        -e "EJABBERD_ADMIN=root@ejabberd" \
        -e "EJABBERD_ADMIN_PWD=vagrant" \
        rroemhild/ejabberd

Start [node-xmpp-bosh](https://github.com/dhruvbird/node-xmpp-bosh):

    docker run --rm \
        --name node-xmpp-bosh \
        --link ejabberd:ejabberd \
        -p 5280:5280 \
        franzabzieher/node-xmpp-bosh

Access administration of ejabberd using https://192.168.59.103:52443/admin/