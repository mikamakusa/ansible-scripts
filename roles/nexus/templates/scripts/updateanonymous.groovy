anonymous = security.securitySystem.getUser("anonymous")
status = anonymous.getStatus()
if (status == status.active) {
	log.info('Anonymous User enabled. Deactivating.')
	anonymous.setStatus(status.disabled)
	security.securitySystem.updateUser(anonymous)
}
log.info('Changing anonymous user status')
log.info('anonymous user status succesfully updated')
