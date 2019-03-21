import pandas as pd;

df=pd.read_csv("https://gist.githubusercontent.com/seankross/a412dfbd88b3db70b74b/raw/5f23f993cd87c283ce766e7ac6b329ee7cc2e1d1/mtcars.csv")

print(df.head())

print(df.tail())

print(df[0:2])

print(df.columns)

print(df.describe())

print(df.mean)
