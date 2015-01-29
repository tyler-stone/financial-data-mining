function [] = idCent(centroids,tickers)
% display tickers of identified centroids
n = length(centroids);
disp('   cluster Prototypes:')
for i = centroids(1:n)
    disp(tickers(i))
end
    
    
    