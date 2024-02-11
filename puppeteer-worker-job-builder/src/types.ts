/* eslint-disable no-unused-vars */

export type ArrayGeneratorFunction = (...params: any[]) => Promise<[]>;
export type GetValueFromOutputsFunction = (outputs: any[]) => any;
export type GetValueFromParamsFunction = (params: any) => any;
export type VarsHandlerFunction = (vars: any) => any;
export type PuppeteerLifeCycleEvent = "load" | "domcontentloaded" | "networkidle0" | "networkidle2";

export type PrimitiveType = null | undefined | number | string | boolean | object;

export interface ClickOpts { clickCount?: number; }
export interface GetActionOutputOpts { fromCurrent?: number; direct?: number }
export interface GetTextContentOpts { trim?: boolean }

export interface PrettyError {
  name: string,
  message: string,
  stack: string[],
}

export interface DoingInfo {
  job: string;
  action: string;
  stepIdx: number;
  nestingLevel: number;
  stacks: string[];
  at: number;
}