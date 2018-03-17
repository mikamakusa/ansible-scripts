def adminRole = ['nx-admin']

{{ nexus_config.user }} = security.securitySystem.getUser("{{ nexus_config.user }}")
status = {{ nexus_config.user }}.getStatus()
if (status == status.disabled) {
    log.info('Admin user disabled. Activating.')
    {{ nexus_config.user }}.setStatus(status.active)
    security.securitySystem.updateUser({{ nexus_config.user }})
}

log.info('Changing {{ nexus_config.user }} user password')
security.securitySystem.changePassword("{{ nexus_config.user }}", "{{ nexus_config.password }}")
log.info('Admin user successfully updated.')
