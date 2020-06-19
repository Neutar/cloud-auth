
create table neutar_user(
    id uuid PRIMARY KEY,
    account_expired boolean,
    account_locked boolean,
    enabled boolean,
    password varchar(255),
    username varchar(255) UNIQUE);

create table neutar_user_authority(
    neutar_user_id uuid not null references neutar_user(id),
    authority varchar(255) not null);

create table oauth_access_token(
    id uuid PRIMARY KEY,
    authentication oid,
    authentication_id varchar(255),
    client_id varchar(255),
    refresh_token varchar(255),
    token oid,
    token_id varchar(255),
    user_name varchar(255));

create table oauth_client_details(
    id uuid PRIMARY KEY,
    access_token_validity int4,
    additional_information varchar(255),
    authorities varchar(255),
    authorized_grant_types varchar(255),
    autoapprove VARCHAR(255),
    client_id varchar(255),
    client_name varchar(255),
    client_secret varchar(255),
    created timestamp,
    enabled boolean,
    refresh_token_validity int4,
    resource_ids varchar(255),
    scope varchar(255),
    uuid varchar(255),
    web_server_redirect_uri varchar(255));

create table oauth_client_token(
    id uuid PRIMARY KEY,
    authentication_id varchar(255),
    client_id varchar(255),
    token oid,
    token_id varchar(255),
    user_name varchar(255));

create table oauth_code(
    id uuid PRIMARY KEY,
    authentication oid,
    code varchar(255));

create table oauth_refresh_token(
    id uuid PRIMARY KEY,
    authentication oid,
    token oid,
    token_id varchar(255));
