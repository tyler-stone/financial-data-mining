import os
import glob
from xlrd import open_workbook

# intended directory structure
#  /{sample#}/{cluster#}_strat{strategy#}.xlsx
#  /sample0/0_strat0.xlsx
#  /sample0/0_strat1.xlsx
#  /sample0/1_strat0.xlsx
#  /sample0/1_strat1.xlsx
#  /sample1/0_strat0.xlsx
#  /sample1/0_strat1.xlsx
#  /sample1/1_strat0.xlsx
#  /sample1/1_strat1.xlsx

# inputs: number of samples, clusters per sample, and the directory
# outputs: printed results for optimal strategies per cluster per sample
def strategy_analysis(numSamples, clustersPer, dir):
	print('Beginning strategy analysis')
	print('--------------------------------------------')
	results = []
	for i in range(numSamples):
		print('Sample %d\n' % (i))
		results.append([])
		reports = find_reports('%s/sample%s' % (dir,i), clustersPer)

		for j in range(len(reports)):
			print('\nCluster %d' % (j))
			results[i].append(analyze_group(reports[j]))

		print('--------------------------------------------')


# inputs: directory, number of cluster prototypes
# outputs: 2-d array of reports for each cluster prototype
def find_reports(dir, clusters):
	reports = []
	os.chdir(dir)
	for i in range(clusters):
		reports.append([])
		for file in glob.glob("%d_*.xlsx" % (i)):
			reports[i].append(file)
	return reports	

# inputs: array of reports for a single prototype
# outputs: best metric result for the prototype
def analyze_group(reports):
	bestIndex = 0
	score = []
	metrics = []

	for i in range(len(reports)):
		# print("getting info for: %s" % (reports[i]))
		metrics.append(getMetric(reports[i]))
		score.append(0)

		# apply weighting to get 'strategy score'
		score[i]  = metrics[i].netProfit * 0.40
		score[i] += (metrics[i].profitFactor * 0.2 if metrics[i].profitFactor != 'n/a' else 20)
		score[i] += metrics[i].roi * 0.05
		score[i] += metrics[i].annualReturn * 0.1
		score[i] += metrics[i].numberTrades * 0.05
		score[i] += metrics[i].returnRetracement * 0.05
		score[i] += metrics[i].rina * 0.1
		score[i] += metrics[i].kRatio * 0.05

	bestIndex = score.index(max(score))
	print('Best Strategy File: %s' % (reports[bestIndex]))
	print('Best Strategy Score: %d' % (score[bestIndex]))
	print('Best Strategy: %s' % (metrics[bestIndex].strategy))
	return metrics[bestIndex]
		
# inputs: name of report to read
# outputs: metric with extracted performance data
def getMetric(report):
	book = open_workbook(report)
	result = PerformanceMetric()

	sheet = book.sheet_by_index(7)
	result.strategy = '\n'.join([sheet.cell(8,0).value, sheet.cell(9,0).value, sheet.cell(10,0).value, sheet.cell(11,0).value])
	result.prototype = sheet.cell(2,1).value

	sheet = book.sheet_by_index(0)
	result.netProfit = sheet.cell(3,1).value
	result.profitFactor = sheet.cell(6,1).value
	result.numberTrades = sheet.cell(21,1).value
	result.roi = sheet.cell(53,1).value
	result.annualReturn = sheet.cell(54,1).value
	result.returnRetracement = sheet.cell(60,1).value
	result.rina = sheet.cell(61,1).value
	result.kRatio = sheet.cell(63,1).value

	return result

# class for organizing performance data
class PerformanceMetric:
	def __init__(self, strategy=None, prototype=None, 
		netProfit=None, profitFactor=None, numberTrades=None, roi=None, 
		annualReturn=None, returnRetracement=None, rina=None, kRatio=None):
		self.strategy = strategy
		self.prototype = prototype
		self.netProfit = netProfit
		self.profitFactor = profitFactor
		self.numberTrades = numberTrades
		self.roi = roi
		self.annualReturn = annualReturn
		self.returnRetracement = returnRetracement
		self.rina = rina
		self.kRatio = kRatio



# find_reports('./test/cluster1', 10)
strategy_analysis(5, 10, 'C:/Users/Tyler/Desktop/Projects/strategy_report_reader/samples')
