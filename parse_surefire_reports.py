import os
import xml.etree.ElementTree as ET
import matplotlib.pyplot as plt

def parse_surefire_report(file_path):
    tree = ET.parse(file_path)
    root = tree.getroot()
    tests = int(root.attrib['tests'])
    failures = int(root.attrib['failures'])
    errors = int(root.attrib['errors'])
    skipped = int(root.attrib['skipped'])
    return tests, failures, errors, skipped

def collect_statistics(report_dir):
    total_tests = 0
    total_failures = 0
    total_errors = 0
    total_skipped = 0

    for file_name in os.listdir(report_dir):
        if file_name.endswith('.xml'):
            file_path = os.path.join(report_dir, file_name)
            tests, failures, errors, skipped = parse_surefire_report(file_path)
            total_tests += tests
            total_failures += failures
            total_errors += errors
            total_skipped += skipped

    return total_tests, total_failures, total_errors, total_skipped

def plot_statistics(total_tests, total_failures, total_errors, total_skipped):
    labels = ['Tests', 'Failures', 'Errors', 'Skipped']
    values = [total_tests, total_failures, total_errors, total_skipped]
    colors = ['#4CAF50', '#FF5252', '#FF9800', '#9E9E9E']

    plt.figure(figsize=(10, 6))
    bars = plt.bar(labels, values, color=colors)
    plt.title('Unit Test Results Canela Account')
    plt.ylabel('Number of Tests')

    for bar in bars:
        yval = bar.get_height()
        plt.text(bar.get_x() + bar.get_width()/2, yval, int(yval), va='bottom')

    plt.show()

if __name__ == "__main__":
    report_dir = 'target/surefire-reports'
    total_tests, total_failures, total_errors, total_skipped = collect_statistics(report_dir)
    plot_statistics(total_tests, total_failures, total_errors, total_skipped)
