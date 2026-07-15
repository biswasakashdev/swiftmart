import { CSSProperties } from "react";

export interface Page {
  id: string;
  type: string;
  styles?: CSSProperties;
  props?: Record<string, string>;
  children?: Page[];
}

export interface Root {
  title: string;
  theme: {
    global: CSSProperties;
  };
  description: string;
  pages: Page[];
}
