import os

import testinfra.utils.ansible_runner

testinfra_hosts = testinfra.utils.ansible_runner.AnsibleRunner(
    os.environ['MOLECULE_INVENTORY_FILE']).get_hosts('all')


def test_hosts_file(host):
    f = host.file('/etc/hosts')

    assert f.exists
    assert f.user == 'root'
    assert f.group == 'root'


def test_prometheus_running(host):
    f = host.service('prometheus')

    assert f.is_running
    assert f.is_enabled


def test_node_exporter_running(host):
    f = host.service('node_exporter')

    assert f.is_running
    assert f.is_enabled


def test_prometheus_group(host):
    f = host.group('prometheus')

    assert f.exists


def test_prometheus_directory(host):
    f = host.file('/etc/prometheus')

    assert f.is_directory
    assert f.mode
    assert f.user
    assert f.group
